/*
@author https://yunp.top
*/

package top.yunp.asws.http
{

    public class Request
    {

        private var _originalReq:*;
        private var _args:Array;
        private var _controllerName:String;
        private var _actionName:String;

        public function Request(orginalReq:*)
        {
            this._originalReq = orginalReq;

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
            return _originalReq["getUri"]();
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
    }
}