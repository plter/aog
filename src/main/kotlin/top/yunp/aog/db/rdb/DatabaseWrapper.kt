/*
Created on 2025/11/18
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import org.ktorm.database.Database
import org.ktorm.dsl.from

class DatabaseWrapper(public val ktorm: Database) {
//    fun exec(sql: String) {
//        ktorm.useConnection { connection ->
//            connection.createStatement().executeQuery(sql).asIterable()
//        }
//    }

    fun from(table: KTable): KQuerySource {
        return KQuerySource(ktorm.from(table))
    }
}