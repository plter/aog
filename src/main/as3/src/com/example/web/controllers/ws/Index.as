package com.example.web.controllers.ws
{
    import top.yunp.aog.controllers.Action;
    import top.yunp.aog.http.AdapterContext;
    import top.yunp.aog.http.WebSocketFrame;

    public class Index extends Action
    {

        override public function handle(context:AdapterContext):void
        {
            while (true)
            {
                var f:WebSocketFrame = context.receive();

                if (f == null)
                {
                    break;
                }

                context.sendText("You said: " + f.readText());
            }

            console.log("WebSocket end");
        }
    }
}