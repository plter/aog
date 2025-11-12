/*
@author https://yunp.top
 */

import org.springframework.boot.SpringApplication;
import top.yunp.asws.SApplication;
import top.yunp.asws.utils.ArgsParser;

void main(String[] args) {
    ArgsParser.parseArgs(args);

    if (ArgsParser.getArg("--file")==null){
        System.out.println("Usage:\n  asws --file=Main.js --class=Main");
        return;
    }

    SpringApplication.run(SApplication.class, args);
}