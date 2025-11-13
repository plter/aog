package
{

    import top.yunp.asws.controllers.ControllersManager;
    import com.example.web.controllers.index.IndexController;

    public class Main
    {
        public function Main()
        {

            var cm:ControllersManager = new ControllersManager();
            cm.addController("", new IndexController());

            eval("globalThis")["application"] = cm.handle;
        }
    }
}