package com.itnxd.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ITNXD
 * @create 2021-12-10 17:45
 *
 * 1. 整合MP
 *  导入依赖、配置数据源、主键自增、mapper扫描、xml位置配置
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.itnxd.gulimall.product.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }
}
