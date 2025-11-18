/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.engine

import com.google.gson.Gson
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.server.pebble.respondTemplate
import io.ktor.server.request.uri
import io.ktor.server.response.respondRedirect
import io.ktor.server.response.respondText
import io.ktor.server.routing.RoutingContext
import io.ktor.server.websocket.DefaultWebSocketServerSession
import io.ktor.websocket.send
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.ktorm.database.Database
import org.slf4j.LoggerFactory
import top.yunp.aog.async.IOScope
import top.yunp.aog.db.DatabaseWrapper
import top.yunp.aog.db.getKtorm
import top.yunp.aog.db.getKtormWrapper

class JsHttpContext(
    private val routingContext: RoutingContext? = null,
    private val webSocketSession: DefaultWebSocketServerSession? = null
) {
    init {
        if ((routingContext == null && webSocketSession == null) || (routingContext != null && webSocketSession != null)) {
            throw IllegalArgumentException()
        }
    }

    fun isWebSocket(): Boolean {
        return webSocketSession != null
    }

    fun receive(): WebSocketFrame? {
        if (webSocketSession == null || !webSocketSession.isActive) {
            return null
        }
        var r: WebSocketFrame? = null
        try {
            IOScope.launch {
                r = WebSocketFrame(webSocketSession.incoming.receive())
            }.asCompletableFuture().get()
        } catch (e: Throwable) {
            LOG.warn(e.message)
            return null
        }
        return r
    }

    fun sendText(content: String) {
        IOScope.launch {
            webSocketSession?.send(content)
        }.asCompletableFuture().get()
    }

    fun sendBytes(data: ByteArray) {
        IOScope.launch {
            webSocketSession?.send(data)
        }.asCompletableFuture().get()
    }

    val uri: String
        get() {
            val req = (routingContext?.call?.request) ?: (webSocketSession?.call?.request)
            return req?.uri ?: ""
        }

    fun end(content: String, contentType: String = "text/html", code: Int = 200) {
        val call = (routingContext?.call) ?: (webSocketSession?.call) ?: return

        IOScope.launch {
            call.respondText(content, ContentType.parse(contentType), HttpStatusCode(code, "OK"))
        }.asCompletableFuture().get()
    }

    fun appendCookie(
        name: String, value: String,
        maxAge: Long? = null, domain: String? = null, path: String? = null
    ) {
        routingContext?.call?.response?.cookies?.append(
            name, value,
            maxAge = maxAge,
            domain = domain,
            path = path
        )
    }


    fun template(template: String, data: String) {
        @Suppress("UNCHECKED_CAST")
        val model: Map<String, Any> = GSON.fromJson(data, Map::class.java) as Map<String, Any>
        IOScope.launch {
            routingContext?.call?.respondTemplate(template, model)
        }.asCompletableFuture().get()
    }

    fun redirect(url: String, permanent: Boolean) {
        IOScope.launch {
            routingContext?.call?.respondRedirect(Url(url), permanent)
        }.asCompletableFuture().get()
    }

    val db: DatabaseWrapper?
        get() {
            return ((routingContext?.call) ?: (webSocketSession?.call))?.application?.getKtormWrapper()
        }

    companion object {
        val GSON = Gson()
        val LOG = LoggerFactory.getLogger(JsHttpContext::class.java)
    }
}