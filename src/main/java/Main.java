/*
@author https://yunp.top
 */

import org.springframework.boot.SpringApplication;
import top.yunp.asws.SApplication;
import top.yunp.asws.utils.ArgsParser;

void main(String[] args) {
    ArgsParser.parseArgs(args);
    SpringApplication.run(SApplication.class, args);
}