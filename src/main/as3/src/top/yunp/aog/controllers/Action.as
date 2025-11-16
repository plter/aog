/*
@author https://yunp.top
*/

package top.yunp.aog.controllers
{

    import top.yunp.aog.http.AdapterContext;

    public abstract class Action
    {

        public abstract function handle(context:AdapterContext):void;

    }
}