package com.example.web.controllers.user
{
    import top.yunp.aog.controllers.Action;
    import top.yunp.aog.http.AdapterContext;
    import com.example.web.db.tables.User;

    public class Index extends Action
    {
        override public function handle(context:AdapterContext):void
        {
            console.log(context.db.from(User.user));
            context.end("OK");
        }
    }
}