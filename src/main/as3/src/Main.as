package
{

    public class Main
    {
        public function Main()
        {
            var globalThis:* = eval("globalThis");
            globalThis["application"] = function(req:*, res:*):void
            {
                res.write("Hello");
            };
        }
    }
}