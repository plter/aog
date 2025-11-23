package com.example.web.controllers.user
{
    import top.yunp.aog.controllers.Action;
    import top.yunp.aog.http.AdapterContext;
    import com.example.web.db.tables.User;

    public class Index extends Action
    {
        override public function handle(context:AdapterContext):void
        {

            // var data:Array = context.db.from(User.user).select().where(
            // User.user.id.gt(0).and(User.user.id.lt(2))
            // ).toList();
            // console.log(data);

            var data:* = context.db.exec("select * from auth_user");
            console.log(data);
            context.end("OK");
        }
    }
}