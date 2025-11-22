/*
Created on 2025/11/20
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import org.ktorm.dsl.QuerySource
import org.ktorm.dsl.select

class KQuerySource(private val querySource: QuerySource) {

    fun select(): KQuery {
        return KQuery(querySource.select())
    }
}