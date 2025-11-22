/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.short
import org.ktorm.schema.text
import org.ktorm.schema.varchar

class KTable(name: String) : Table<Nothing>(name) {

    fun bigintPrimary(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(long(field).primaryKey())
    }

    fun bigint(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(long(field))
    }

    fun integer(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(int(field))
    }

    fun integerPrimary(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(int(field).primaryKey())
    }

    fun smallint(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(short(field))
    }

    fun string(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(varchar(field))
    }

    fun ktext(field: String): ColumnDeclaringWrapper {
        return ColumnDeclaringWrapper(text(field))
    }
}