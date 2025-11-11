package top.yunp.asws;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.graalvm.polyglot.Source;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yunp.asws.engine.JsRuntime;
import top.yunp.asws.engine.Languages;
import top.yunp.asws.http.impl.HttpServletRequestWrapper;
import top.yunp.asws.http.impl.HttpServletResponseWrapper;

import java.io.File;
import java.io.IOException;

@RestController
public class Gateway {

    private JsRuntime jsRuntime;

    {
        try {
            jsRuntime = new JsRuntime(Source.newBuilder(Languages.JS, new File("src/main/as3/bin/js-release/index.js")).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/*")
    public void index(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setCharacterEncoding("UTF-8");
        jsRuntime.handle(new HttpServletRequestWrapper(req), new HttpServletResponseWrapper(res));
    }

}
