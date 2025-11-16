/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.http
{
    public class WebSocketFrame
    {

        private var _nativeFrame:* = null;
        private var _type:String;

        public function WebSocketFrame(nativeFrame:*)
        {
            _nativeFrame = nativeFrame;
            _type = nativeFrame["getType"]();
        }

        public function readText():String
        {
            return _nativeFrame["readText"]();
        }

        public function readBytes():*
        {
            return _nativeFrame["readBytes"]();
        }

        public function fin():Boolean
        {
            return _nativeFrame["fin"]();
        }

        public function get type():String
        {
            return _type;
        }

        public function toString():String
        {
            return "WebSocketFrame[type=" + type + "]";
        }
    }
}