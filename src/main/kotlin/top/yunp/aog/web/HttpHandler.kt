/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog.web

import io.ktor.server.response.respondText
import io.ktor.server.routing.RoutingContext


suspend fun RoutingContext.handleHttpRequest() {
    call.respondText("OK")
}