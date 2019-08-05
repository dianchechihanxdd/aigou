package cn.itsource.aigou.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient// eureka的客户端
@MapperScan(basePackages="cn.itsource.aigou.product.mapper") //mapper和xml都扫描了
public class ProductApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication8002.class);
    }
}
