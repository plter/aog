package com.example.web.controllers.index
{

    import top.yunp.aog.controllers.Action;
    import top.yunp.aog.http.AdapterContext;

    public class ModelAction extends Action
    {
        override public function handle(context:AdapterContext):void
        {
            context.template("index.html", {user: "aog"});
        }
    }
}