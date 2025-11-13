package com.example.web.controllers.index
{
    import top.yunp.asws.controllers.Controller;

    public class IndexController extends Controller
    {

        public function IndexController()
        {
            addAction("", new IndexAction());
        }
    }
}