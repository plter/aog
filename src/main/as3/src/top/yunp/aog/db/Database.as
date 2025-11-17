/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db
{
    public class Database
    {

        private var _kDb:*;

        public function Database(nativeDb:*)
        {
            _kDb = nativeDb;
        }

        public function from(table:Table):*
        {
            return new QuerySource(_kDb["from"](table.nativeTable));
        }
    }
}