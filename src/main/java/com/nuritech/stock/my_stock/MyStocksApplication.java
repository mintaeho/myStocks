package com.nuritech.stock.my_stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MyStocksApplication {
    public static void main(String[] args){
        SpringApplication.run(MyStocksApplication.class, args);
    }
}
// 재반영