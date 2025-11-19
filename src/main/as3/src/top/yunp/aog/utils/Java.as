/*
Created on 2025/11/16
@author https://yunp.top
 */

package top.yunp.aog.utils
{

    public class Java
    {
        private static const NativeJava:* = eval("Java");

        public static function type(def:String):*
        {
            return NativeJava["type"](def);
        }

        public static function inspect(obj:*):void
        {
            var methods:Array = obj["getClass"]()["getMethods"]();
            for each (var method:Object in methods)
            {
                console.log("Method: " + method["getName"]());
            }
        }
    }

}