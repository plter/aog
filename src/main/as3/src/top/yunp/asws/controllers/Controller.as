/*
@author https://yunp.top
*/

package top.yunp.asws.controllers
{
    public class Controller
    {

        private var _actions:Map = new Map();

        public function Controller()
        {

        }

        public function addAction(name:String, action:Action):void
        {
            _actions.set (name, action);
        }
    }
}