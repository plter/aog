package com.example.web.controllers.index
{
    import top.yunp.asws.controllers.Action;
    import top.yunp.asws.http.Request;
    import top.yunp.asws.http.Response;

    internal class IndexAction extends Action
    {
        public function IndexAction()
        {

        }

        override public function handle(req:Request, res:Response):void
        {
            res.write("Hello World");
        }

    }
}