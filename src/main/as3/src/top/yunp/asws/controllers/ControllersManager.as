/*
@author https://yunp.top
*/

package top.yunp.asws.controllers
{
    import top.yunp.asws.http.Request;
    import top.yunp.asws.http.Response;

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

        public function handle(req:*, res:*):void
        {
            var request:Request = new Request(req);
            var response:Response = new Response(res);

            var c:Controller = controllers.get (request.controllerName);
            if (!c)
            {
                response.setStatus(404);
                response.write("Not Found");
                return;
            }
            var a:Action = c.actions.get (request.actionName);
            if (!a)
            {
                response.setStatus(404);
                response.write("Not Found");
                return;
            }

            a.handle(request, response);
        }
    }
}