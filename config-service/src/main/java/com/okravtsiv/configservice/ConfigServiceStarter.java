package com.okravtsiv.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceStarter.class, args);
    }
}
