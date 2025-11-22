/*
Created on 2025/11/20
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import org.ktorm.dsl.Query
import org.ktorm.dsl.map
import org.ktorm.dsl.where
import org.ktorm.schema.ColumnDeclaring

class KQuery(private val query: Query) {
    fun where(condition: ColumnDeclaring<Boolean>): KQuery {
        return KQuery(query.where(condition))
    }

    fun toList(): List<MutableMap<String, Any>> {
        return query.map { it.toMap() }
    }
}