/*
@author https://yunp.top
*/

package top.yunp.asws.controllers
{
    public class ControllersManager
    {

        private var _controllers:Map = new Map();

        public function ControllersManager()
        {

        }

        public function addController(name:String, controller:Controller):void
        {
            _controllers.set (name, controller);
        }

        public function handle(req:*, res:*):void
        {
            res["write"]("Hello");
        }
    }
}