/*
Created on 2025/11/15
@author https://yunp.top
 */

package top.yunp.aog.constants

import io.ktor.util.AttributeKey
import org.ktorm.database.Database
import top.yunp.aog.engine.JsRuntime
import javax.sql.DataSource

object ApplicationAttrKeys {
    val DEFAULT_JS_RUNTIME = AttributeKey<JsRuntime>("DEFAULT_JS_RUNTIME")
    val DB_CONNECTOR = AttributeKey<DataSource>("DB_CONNECTOR")
    val KTORM = AttributeKey<Database>("KTORM")
}