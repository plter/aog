/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db

import org.ktorm.schema.Column
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.short
import org.ktorm.schema.text
import org.ktorm.schema.varchar

class KTable(name: String) : Table<Nothing>(name) {
    fun bigint(field: String): Column<Long> {
        return long(field)
    }

    fun integer(field: String): Column<Int> {
        return int(field)
    }

    fun smallint(field: String): Column<Short> {
        return short(field)
    }

    fun string(field: String): Column<String> {
        return varchar(field)
    }

    fun ktext(field: String): Column<String> {
        return text(field)
    }
}