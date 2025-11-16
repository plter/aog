/*
@author https://yunp.top
*/

package top.yunp.aog.controllers
{
    import top.yunp.aog.http.AdapterContext;

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

        public function get controllers():Map
        {
            return _controllers;
        }

        public function handle(originalContext:*):void
        {
            var context:AdapterContext = new AdapterContext(originalContext);

            var c:Controller = controllers.get (context.controllerName);
            if (!c)
            {
                context.end("Not Found", "text/html", 404);
                return;
            }
            var a:Action = c.actions.get (context.actionName);
            if (!a)
            {
                context.end("Not Found", "text/html", 404);
                return;
            }

            a.handle(context);
        }
    }
}