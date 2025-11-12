/*
@author https://yunp.top
 */
package top.yunp.asws.engine;

import jakarta.servlet.http.HttpServletResponse;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import top.yunp.asws.http.IHttpRequest;
import top.yunp.asws.http.IHttpResponse;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class JsRuntime {

    private final Source entrypoint;
    private final String mainClassName;
    private final Queue<Context> contexts = new ConcurrentLinkedQueue<>();

    public JsRuntime(Source entrypoint) {
        this(entrypoint, null);
    }

    public JsRuntime(Source entrypoint, String mainClassName) {
        this.entrypoint = entrypoint;
        this.mainClassName = mainClassName;
    }

    private Context accquireContext() throws IOException {
        Context context = contexts.poll();
        if (context == null) {
            context = Context.newBuilder(Languages.JS)
                    .allowAllAccess(true)
                    .option("js.commonjs-require", "true")
                    .build();

            context.eval(entrypoint);

            if (mainClassName != null) {
                context.eval(Languages.JS, "new " + mainClassName + "()");
            }
        }
        return context;
    }

    private void recycleContext(Context context) {
        contexts.offer(context);
    }

    public void handle(IHttpRequest req, IHttpResponse res) throws IOException {
        var context = accquireContext();
        try {
            var func = context.eval("js", "application");
            func.executeVoid(req, res);
        } catch (Throwable e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            res.write("Internal server error");
            e.printStackTrace();
        }
        recycleContext(context);
    }
}
