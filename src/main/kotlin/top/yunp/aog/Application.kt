/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import io.pebbletemplates.pebble.loader.ClasspathLoader
import top.yunp.aog.web.handleHttpRequest
import top.yunp.aog.web.handleWebSocketRequest
import kotlin.time.Duration.Companion.seconds

fun Application.module() {
    install(Pebble) {
        loader(ClasspathLoader().apply {
            prefix = "templates"
        })
    }
    install(WebSockets) {
        pingPeriod = 15.seconds
        timeout = 15.seconds
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    routing {

        get("/{...}") { handleHttpRequest() }
        post("/{...}") { handleHttpRequest() }

        staticResources("/static", "static")

        get("/pebble-index") {
            call.respond(PebbleContent("pebble-index.html", mapOf("user" to 1)))
        }
        webSocket("/ws/{...}") { handleWebSocketRequest() }
    }
}
