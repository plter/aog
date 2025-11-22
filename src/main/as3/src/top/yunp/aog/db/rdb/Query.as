/*
Created on 2025/11/20
@author https://yunp.top
 */

package top.yunp.aog.db.rdb
{
    public class Query
    {
        private var _kQuery:*;

        public function Query(kQuery:*)
        {
            _kQuery = kQuery;
        }

        public function where(condition:ColumnDeclaring):Query
        {
            return new Query(_kQuery["where"](condition.nativeObject["getKColumnDeclaring"]()));
        }

        public function toList():Array
        {
            return _kQuery["toList"]();
        }
    }
}