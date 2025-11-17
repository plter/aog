/*
Created on 2025/11/17
@author https://yunp.top
 */

package top.yunp.aog.db
{
    public class Table
    {

        private var _name:String;

        public function Table(name:String)
        {
            _name = name;

            // TODO wrap the native table
        }

        public function get name():String
        {
            return _name;
        }
    }
}