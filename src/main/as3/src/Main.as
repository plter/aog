/*
Created on 2025/11/16
@author https://yunp.top
 */

package
{

    import com.example.web.controllers.index.IndexController;

    import top.yunp.aog.controllers.ControllersManager;
    import com.example.web.controllers.ws.WsController;
    import com.example.web.controllers.user.UserController;

    public class Main
    {
        public function Main()
        {
            var cm:ControllersManager = new ControllersManager();
            cm.addController("", new IndexController());
            cm.addController("default", new IndexController());
            cm.addController("ws", new WsController());
            cm.addController("user", new UserController());

            eval("globalThis")["application"] = cm.handle;
        }
    }
}