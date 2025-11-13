/*
@author https://yunp.top
 */

import org.springframework.boot.SpringApplication
import top.yunp.asws.SApplication
import top.yunp.asws.utils.ArgsParser

fun main(args: Array<String>) {
    ArgsParser.parseArgs(args)

    if (ArgsParser.getArg("--file") == null) {
        println("Usage:\n  asws --file=Main.js --class=Main")
        return
    }

    SpringApplication.run(SApplication::class.java, *args)
}