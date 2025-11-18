/*
Created on 2025/11/18
@author https://yunp.top
 */

package top.yunp.aog.db

import org.ktorm.database.Database
import org.ktorm.database.asIterable

class DatabaseWrapper(private val ktorm: Database) {
//    fun exec(sql: String) {
//        ktorm.useConnection { connection ->
//            connection.createStatement().executeQuery(sql).asIterable()
//        }
//    }
}