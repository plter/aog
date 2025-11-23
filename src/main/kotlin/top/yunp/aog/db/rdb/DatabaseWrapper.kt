/*
Created on 2025/11/18
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import org.ktorm.database.Database
import org.ktorm.dsl.from
import java.sql.Date

class DatabaseWrapper(val ktorm: Database) {
    fun exec(sql: String, args: List<Any> = emptyList(), type: String = SqlExecType.QUERY): Any {
        return ktorm.useConnection { connection ->
            connection.prepareStatement(sql).use { statement ->
                args.forEachIndexed { index, any ->
                    if (any is String) {
                        statement.setString(index + 1, any)
                    } else if (any is Int) {
                        statement.setInt(index + 1, any)
                    } else if (any is Double) {
                        statement.setDouble(index + 1, any)
                    } else if (any is Long) {
                        statement.setLong(index + 1, any)
                    } else if (any is Float) {
                        statement.setFloat(index + 1, any)
                    } else if (any is Short) {
                        statement.setShort(index + 1, any)
                    } else if (any is Date) {
                        statement.setDate(index + 1, any)
                    } else {
                        statement.setObject(index + 1, any)
                    }
                }

                if (type == SqlExecType.QUERY) {
                    val rs = statement.executeQuery()
                    val result = mutableListOf<MutableMap<String, Any>>()
                    while (rs.next()) {
                        result.add(rs.toMap())
                    }
                    return@use result
                } else if (type == SqlExecType.UPDATE) {
                    return@use statement.executeUpdate()
                } else {
                    return@use statement.execute()
                }
            }
        }
    }

    fun from(table: KTable): KQuerySource {
        return KQuerySource(ktorm.from(table))
    }
}