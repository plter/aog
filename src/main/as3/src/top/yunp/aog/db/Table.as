/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db
{
    import top.yunp.aog.utils.Java;

    public class Table
    {

        private var _name:String;
        private var _kTable:*;
        private static var KTableClass:* = Java.type("top.yunp.aog.db.KTable");

        public function Table(name:String)
        {
            _name = name;

            _kTable = new KTableClass(name);
        }

        public function get name():String
        {
            return _name;
        }

        internal function get nativeTable():*
        {
            return _kTable;
        }

        public function bigint(field:String):Column
        {
            return new Column(_kTable["bigint"](field));
        }

        public function integer(field:String):Column
        {
            return new Column(_kTable["integer"](field));
        }

        public function smallint(field:String):Column
        {
            return new Column(_kTable["smallint"](field));
        }
        public function string(field:String):Column
        {
            return new Column(_kTable["string"](field));
        }
        public function text(field:String):Column
        {
            return new Column(_kTable["ktext"](field));
        }
    }
}