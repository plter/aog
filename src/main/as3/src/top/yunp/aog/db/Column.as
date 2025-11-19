/*
Created on 2025/11/18
@author https://yunp.top
 */

package top.yunp.aog.db
{
    public class Column
    {
        private var _kColumn:*;

        public function Column(kColumn:*)
        {
            _kColumn = kColumn;
        }

        public function primaryKey():Column
        {
            _kColumn["primaryKey"]();
            return this;
        }
    }
}