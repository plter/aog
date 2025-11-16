package com.example.web.controllers.index
{
    import top.yunp.aog.controllers.Controller;

    public class IndexController extends Controller
    {

        public function IndexController()
        {
            addAction("", new IndexAction());
            addAction("model", new ModelAction());
        }
    }
}