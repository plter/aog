/*
Created on 2025/11/22
@author https://yunp.top
 */
package top.yunp.aog.db.rdb

import org.ktorm.dsl.and
import org.ktorm.dsl.or
import org.ktorm.schema.ColumnDeclaring

class ExpressionWrapper(expression: ColumnDeclaring<*>) : ColumnDeclaringWrapper(expression) {
    fun and(value: Boolean): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<Boolean>).and(value))
    }

    fun and(value: ColumnDeclaring<Boolean>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<Boolean>).and(value))
    }

    fun or(value: Boolean): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<Boolean>).or(value))
    }

    fun or(value: ColumnDeclaring<Boolean>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<Boolean>).or(value))
    }
}