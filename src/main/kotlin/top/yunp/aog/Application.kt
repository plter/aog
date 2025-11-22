/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.pebble.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.pebbletemplates.pebble.loader.FileLoader
import top.yunp.aog.async.vtCoroutine
import top.yunp.aog.engine.getJsRuntime
import java.io.File
import kotlin.time.Duration.Companion.seconds

fun Application.module() {
    install(Pebble) {
        loader(FileLoader().apply {
            prefix = this@module.environment.config.property("aog.web.templates").getString()
        })
    }
    install(WebSockets) {
        pingPeriod = 15.seconds
        timeout = 15.seconds
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    routing {
        get("/{...}") { vtCoroutine { getJsRuntime().run(this) } }
        post("/{...}") { vtCoroutine { getJsRuntime().run(this) } }
        staticFiles("/static", File(environment.config.property("aog.web.static").getString()))
        webSocket("/${environment.config.property("aog.web.ws_base").getString()}/{...}") {
            vtCoroutine { getJsRuntime().run(this) }
        }
    }
}
