/*
@author https://yunp.top
 */

import io.ktor.server.netty.*
import top.yunp.asws.utils.ArgsParser

fun main(args: Array<String>) {
    ArgsParser.parseArgs(args)

    if (ArgsParser.getArg("--file") == null) {
        println("Usage:\n  asws --file=Main.js --class=Main")
        return
    }

    EngineMain.main(args)
}