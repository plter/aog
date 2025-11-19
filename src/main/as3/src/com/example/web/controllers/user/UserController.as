package com.example.web.controllers.user
{
    import top.yunp.aog.controllers.Controller;

    public class UserController extends Controller
    {

        public function UserController()
        {
            addAction("index", new Index());
        }
    }
}