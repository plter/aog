package top.yunp.aog

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import io.pebbletemplates.pebble.loader.ClasspathLoader
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
        get("/") {
            call.respondText("Hello World!")
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")

        get("/pebble-index") {
            call.respond(PebbleContent("pebble-index.html", mapOf("user" to 1)))
        }
        webSocket("/ws") { // websocketSession
            for (frame in incoming) {
                if (frame is Frame.Text) {
                    val text = frame.readText()
                    outgoing.send(Frame.Text("YOU SAID: $text"))
                    if (text.equals("bye", ignoreCase = true)) {
                        close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
                    }
                }
            }
        }
    }
}
