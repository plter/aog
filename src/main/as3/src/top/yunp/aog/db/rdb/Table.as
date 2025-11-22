/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db.rdb
{
    import top.yunp.aog.utils.Java;

    public class Table
    {

        private var _name:String;
        private var _nativeObject:*;
        private static var KTableClass:* = Java.type("top.yunp.aog.db.rdb.KTable");

        public function Table(name:String)
        {
            _name = name;

            _nativeObject = new KTableClass(name);
        }

        public function get name():String
        {
            return _name;
        }

        internal function get nativeObject():*
        {
            return _nativeObject;
        }

        protected function bigint(field:String):Column
        {
            return new Column(_nativeObject["bigint"](field));
        }

        protected function bigintPrimary(field:String):Column
        {
            return new Column(_nativeObject["bigintPrimary"](field));
        }

        protected function integer(field:String):Column
        {
            return new Column(_nativeObject["integer"](field));
        }

        protected function integerPrimary(field:String):Column
        {
            return new Column(_nativeObject["integerPrimary"](field));
        }

        protected function smallint(field:String):Column
        {
            return new Column(_nativeObject["smallint"](field));
        }
        protected function string(field:String):Column
        {
            return new Column(_nativeObject["string"](field));
        }
        protected function text(field:String):Column
        {
            return new Column(_nativeObject["ktext"](field));
        }
    }
}