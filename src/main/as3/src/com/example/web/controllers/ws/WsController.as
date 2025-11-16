package com.example.web.controllers.ws
{
    import top.yunp.aog.controllers.Controller;

    public class WsController extends Controller
    {
        public function WsController()
        {
            addAction("index", new Index());
            addAction("data", new Data());
        }
    }
}