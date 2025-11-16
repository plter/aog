/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.engine

import com.google.gson.Gson
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.pebble.respondTemplate
import io.ktor.server.request.uri
import io.ktor.server.response.respondText
import io.ktor.server.routing.RoutingContext
import io.ktor.server.websocket.DefaultWebSocketServerSession
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import top.yunp.aog.async.IOScope

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


    fun template(template: String, data: String) {
        @Suppress("UNCHECKED_CAST")
        val model: Map<String, Any> = GSON.fromJson(data, Map::class.java) as Map<String, Any>
        IOScope.launch {
            routingContext?.call?.respondTemplate(template, model)
        }.asCompletableFuture().get()
    }

    companion object {
        val GSON = Gson()
    }
}