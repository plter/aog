/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.Application
import top.yunp.aog.constants.ApplicationAttrKeys
import javax.sql.DataSource

fun Application.getDataSource(): DataSource {
    var ds = attributes.getOrNull(ApplicationAttrKeys.DB_CONNECTOR)
    if (ds == null) {
        val dialect = environment.config.property("aog.db.dialect").getString()
        val host = environment.config.property("aog.db.host").getString()
        val port = environment.config.property("aog.db.port").getString()
        val dbName = environment.config.property("aog.db.db_name").getString()
        val user = environment.config.property("aog.db.user").getString()
        val pass = environment.config.property("aog.db.pass").getString()

        val config = HikariConfig()
        config.jdbcUrl = "jdbc:$dialect://$host:$port/$dbName"
        config.username = user
        config.password = pass
        ds = HikariDataSource(config)
        attributes[ApplicationAttrKeys.DB_CONNECTOR] = ds
    }
    return ds
}