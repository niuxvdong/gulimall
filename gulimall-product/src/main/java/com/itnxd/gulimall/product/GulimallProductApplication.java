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
 *
 * 2. 逻辑删除
 *  @TableLogic
 *
 * 3. JSR303
 *  添加校验注解、开启校验@Valid（更强大的@Validated可以实现分组校验）、紧跟BindingResult获取校验信息
 *  分组校验groups + @Validated： -> 添加了分组@Validated则必须指定分组，否则不生效
 *  使用@Valid注解则没有添加分组属性的校验注解也会生效
 *  自定义校验：
 *      编写自定义校验注解
 *      编写自定义校验器
 *      关联二者
 *
 * 4. 全局统一异常处理 @ControllerAdvice
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.itnxd.gulimall.product.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }
}
