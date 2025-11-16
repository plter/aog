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
        private var _uri:String;
        private var _path:String;
        private var _query:String;

        public function AdapterContext(originalContext:*)
        {
            _originalContext = originalContext;
            _uri = _originalContext["getUri"]();

            var qIndex:int = _uri.indexOf("?");
            if (qIndex > -1)
            {
                _path = _uri.substring(0, qIndex);
                _query = _uri.substring(qIndex + 1, _uri.length);
            }
            else
            {
                _path = _uri;
                _query = "";
            }
            var pathTokens:Array = _path.split("/");
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

        public function get uri():String
        {
            return _uri;
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

        public function template(template:String, data:*):void
        {
            _originalContext["template"](template, JSON.stringify(data));
        }

        public function redirect(url:String, permanent:Boolean = false):void
        {
            _originalContext["redirect"](url, permanent);
        }

        public function get path():String
        {
            return _path;
        }

        public function get query():String
        {
            return _query;
        }

        public function receive():WebSocketFrame
        {
            var f:* = _originalContext["receive"]();
            if (f == null)
            {
                return null;
            }
            return new WebSocketFrame(f);
        }

        /**
         * Send websocket text frame
         */
        public function sendText(content:String):void
        {
            _originalContext["sendText"](content);
        }

        public function sendBytes(data:*):void
        {
            _originalContext["sendBytes"](data);
        }
    }
}