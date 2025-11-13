/*
@author https://yunp.top
*/

package top.yunp.asws.http
{
    public class Response
    {

        private var _originalRes:*;

        public function Response(orginalRes:*)
        {
            _originalRes = orginalRes;
        }

        public function write(content:String):void
        {
            _originalRes["write"](content);
        }

        public function setStatus(code:int):void
        {
            _originalRes["setStatus"](code);
        }
    }
}