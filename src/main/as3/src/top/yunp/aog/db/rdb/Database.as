/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db.rdb
{
    public class Database
    {

        private var _kDb:*;

        public function Database(nativeDb:*)
        {
            _kDb = nativeDb;
        }

        public function from(table:Table):QuerySource
        {
            return new QuerySource(_kDb["from"](table.nativeObject));
        }

        public function exec(sql:String, args:Array = null, type:String = "QUERY"):*
        {
            return _kDb["exec"](sql, args || [], type);
        }
    }
}