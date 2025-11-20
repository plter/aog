/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db
{


    public class QuerySource
    {

        private var _kQuerySource:*;

        public function QuerySource(kQuerySource:*)
        {
            _kQuerySource = kQuerySource;
        }

        public function select():Query
        {
            return new Query(_kQuerySource["select"]());
        }
    }
}