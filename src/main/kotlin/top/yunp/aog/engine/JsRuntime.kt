/*
Created on 2025/11/15
@author https://yunp.top
 */
package top.yunp.aog.engine

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import top.yunp.aog.async.IOScope
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue


class JsRuntime(private val source: Source, private val mainClass: String? = null) {

    private val contexts: Queue<Context?> = ConcurrentLinkedQueue<Context?>()

    private fun acquireContext(): Context {
        var context: Context? = contexts.poll()
        if (context == null) {
            context = Context.newBuilder(Languages.JS)
                .allowAllAccess(true)
                .option("js.commonjs-require", "true")
                .build()

            context.eval(source)

            if (mainClass != null) {
                context.eval(Languages.JS, "new $mainClass()")
            }
        }
        return context
    }

    private fun recycleContext(context: Context?) {
        contexts.offer(context)
    }

    fun handle(routingContext: RoutingContext) {
        val context: Context = acquireContext()
        try {
            val func = context.eval("js", "application")
            func.executeVoid(JsHttpContext(routingContext = routingContext))
        } catch (e: Throwable) {
            IOScope.launch {
                routingContext.call.respondText("Internal server error", status = HttpStatusCode.InternalServerError)
            }.asCompletableFuture().get()
            e.printStackTrace()
        }
        recycleContext(context)
    }

    fun handle(session: DefaultWebSocketServerSession) {
        val context: Context = acquireContext()
        try {
            val func = context.eval("js", "application")
            func.executeVoid(JsHttpContext(webSocketSession = session))
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        recycleContext(context)
    }
}