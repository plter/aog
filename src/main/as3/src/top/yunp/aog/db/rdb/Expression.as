/*
Created on 2025/11/22
@author https://yunp.top
 */

package top.yunp.aog.db.rdb
{
    public class Expression extends ColumnDeclaring
    {

        public function Expression(nativeObject:*)
        {
            super(nativeObject);
        }

        public function and(value:*):Expression
        {
            if (value is Expression)
            {
                return new Expression(nativeObject["and"]((value as Expression).nativeObject["getKColumnDeclaring"]()));
            }
            else
            {
                return new Expression(nativeObject["and"](value));
            }
        }

        public function or(value:*):Expression
        {

            if (value is Expression)
            {
                return new Expression(nativeObject["or"]((value as Expression).nativeObject["getKColumnDeclaring"]()));
            }
            else
            {
                return new Expression(nativeObject["or"](value));
            }
        }

    }
}