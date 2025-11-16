/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog.engine

import io.ktor.server.application.Application
import org.graalvm.polyglot.Source
import org.slf4j.LoggerFactory
import top.yunp.aog.constants.ApplicationAttrKeys
import java.io.File

private val LOG = LoggerFactory.getLogger("ApplicationJsRuntime")

fun Application.getJsRuntime(): JsRuntime {
    var runtime = attributes.getOrNull(ApplicationAttrKeys.DEFAULT_JS_RUNTIME)
    if (runtime == null) {
        val file = File(environment.config.property("aog.entrypoint.file").getString())
        if (!file.exists()){
            throw IllegalStateException("File ${file.absoluteFile} not exists")
        }
        val className = environment.config.property("aog.entrypoint.class").getString()
        LOG.info("Entrypoint: file=${file.absoluteFile}, class=$className")
        runtime = JsRuntime(
            Source.newBuilder(Languages.JS, file).build(),
            className
        )
        attributes.put(ApplicationAttrKeys.DEFAULT_JS_RUNTIME, runtime)
    }
    return runtime
}