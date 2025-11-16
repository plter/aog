/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.http
{
    public class AdapterContext
    {

        private var _originalContext:*;
        private var _args:Array;
        private var _controllerName:String;
        private var _actionName:String;

        public function AdapterContext(originalContext:*)
        {
            _originalContext = originalContext;

            var pathTokens:Array = this.getUri().split("/");
            _controllerName = pathTokens[1] || "";
            _actionName = pathTokens[2] || "";

            if (pathTokens.length > 3)
            {
                _args = pathTokens.slice(3);
            }
            else
            {
                _args = [];
            }
        }

        public function getUri():String
        {
            return _originalContext["getUri"]();
        }

        public function get args():Array
        {
            return _args;
        }

        public function get controllerName():String
        {
            return _controllerName;
        }

        public function get actionName():String
        {
            return _actionName;
        }

        public function end(content:String, contentType:String = "text/html", code:int = 200):void
        {
            _originalContext["end"](content, contentType, code);
        }
    }
}