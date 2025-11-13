/*
@author https://yunp.top
*/

package top.yunp.asws.controllers
{

    import top.yunp.asws.http.Request;
    import top.yunp.asws.http.Response;

    public abstract class Action
    {

        public abstract function handle(req:Request, res:Response):void;

    }
}