/*
Created on 2025/11/22
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import java.sql.ResultSet

fun ResultSet.toMap(): MutableMap<String, Any> {
    val m = mutableMapOf<String, Any>()
    for (i in 1..metaData.columnCount) {
        m[metaData.getColumnName(i)] = getObject(i)
    }
    return m
}