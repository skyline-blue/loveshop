package com.loveshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 何锦川
 */
@SpringBootApplication
@EnableTransactionManagement
public class LoveShopApplication {

    static {
        System.setProperty("druid.mysql.usePingMethod", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(LoveShopApplication.class, args);
    }

}
