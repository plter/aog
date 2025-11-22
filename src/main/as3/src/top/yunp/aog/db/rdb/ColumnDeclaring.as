/*
Created on 2025/11/22
@author https://yunp.top
 */

package top.yunp.aog.db.rdb
{
    public class ColumnDeclaring
    {

        private var _nativeObject:*;

        public function ColumnDeclaring(nativeObject:*)
        {
            _nativeObject = nativeObject;
        }

        internal function get nativeObject():*
        {
            return _nativeObject;
        }

        public function eq(value:*):Expression
        {
            return new Expression(nativeObject["eq"](value));
        }

        public function neq(value:*):Expression
        {
            return new Expression(nativeObject["neq"](value));
        }

        public function gt(value:*):Expression
        {
            return new Expression(nativeObject["gt"](value));
        }

        public function gte(value:*):Expression
        {
            return new Expression(nativeObject["gte"](value));
        }

        public function lt(value:*):Expression
        {
            return new Expression(nativeObject["lt"](value));
        }

        public function lte(value:*):Expression
        {
            return new Expression(nativeObject["lte"](value));
        }

        public function like(value:String):Expression
        {
            return new Expression(nativeObject["like"])(value);
        }
    }
}