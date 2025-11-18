/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.db

import io.ktor.server.application.*
import org.ktorm.database.Database
import org.ktorm.database.SqlDialect
import org.ktorm.support.mysql.MySqlDialect
import top.yunp.aog.constants.ApplicationAttrKeys

fun Application.getKtorm(): Database {
    var k = attributes.getOrNull(ApplicationAttrKeys.KTORM)
    if (k == null) {
        val dialectString = environment.config.property("aog.db.dialect").getString()
        var dialect: SqlDialect
        if (dialectString == "mysql") {
            dialect = MySqlDialect()
        } else {
            TODO()
        }
        k = Database.connect(getDataSource(), dialect)
        attributes[ApplicationAttrKeys.KTORM] = k
    }
    return k
}

fun Application.getKtormWrapper(): DatabaseWrapper {
    var kw = attributes.getOrNull(ApplicationAttrKeys.KTORM_WRAPPER)
    if (kw == null) {
        kw = DatabaseWrapper(getKtorm())
        attributes[ApplicationAttrKeys.KTORM_WRAPPER] = kw
    }
    return kw
}