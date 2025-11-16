/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog.constants

import io.ktor.util.AttributeKey
import top.yunp.aog.engine.JsRuntime

object ApplicationAttrKeys {
    val DEFAULT_JS_RUNTIME = AttributeKey<JsRuntime>("DEFAULT_JS_RUNTIME")
}