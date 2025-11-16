/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.engine

import io.ktor.websocket.Frame
import io.ktor.websocket.readBytes
import io.ktor.websocket.readText

class WebSocketFrame(private val frame: Frame) {

    val type = frame.frameType.name

    fun readText(): String? {
        return (frame as? Frame.Text)?.readText()
    }

    fun readBytes(): ByteArray? {
        return (frame as? Frame.Binary)?.readBytes()
    }

    fun fin(): Boolean {
        return frame.fin
    }
}