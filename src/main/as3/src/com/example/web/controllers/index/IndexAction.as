package com.example.web.controllers.index
{
    import top.yunp.aog.controllers.Action;
    import top.yunp.aog.http.AdapterContext;

    internal class IndexAction extends Action
    {

        override public function handle(context:AdapterContext):void
        {
            context.end("Hello World");
        }

    }
}