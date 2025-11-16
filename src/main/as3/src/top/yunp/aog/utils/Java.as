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
    }

}