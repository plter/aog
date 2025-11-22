/*
Created on 2025/11/20
@author https://yunp.top
 */

package top.yunp.aog.db.rdb

import org.ktorm.dsl.*
import org.ktorm.schema.ColumnDeclaring

open class ColumnDeclaringWrapper(val kColumnDeclaring: ColumnDeclaring<*>) {

    fun <T : Any> eq(value: T): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).eq(value))
    }

    fun <T : Any> eq(value: ColumnDeclaring<T>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).eq(value))
    }

    fun <T : Any> neq(value: T): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).neq(value))
    }

    fun <T : Any> neq(value: ColumnDeclaring<T>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).neq(value))
    }

    fun <T : Comparable<T>> gt(value: T): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).gt(value))
    }

    fun <T : Comparable<T>> gt(value: ColumnDeclaring<T>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).gt(value))
    }

    fun <T : Comparable<T>> gte(value: T): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).gte(value))
    }

    fun <T : Comparable<T>> gte(value: ColumnDeclaring<T>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).gte(value))
    }

    fun <T : Comparable<T>> lt(value: T): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).lt(value))
    }

    fun <T : Comparable<T>> lt(value: ColumnDeclaring<T>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).lt(value))
    }

    fun <T : Comparable<T>> lte(value: T): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).lte(value))
    }

    fun <T : Comparable<T>> lte(value: ColumnDeclaring<T>): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<T>).lte(value))
    }


    fun like(value: String): ExpressionWrapper {
        return ExpressionWrapper((kColumnDeclaring as ColumnDeclaring<*>).like(value))
    }
}