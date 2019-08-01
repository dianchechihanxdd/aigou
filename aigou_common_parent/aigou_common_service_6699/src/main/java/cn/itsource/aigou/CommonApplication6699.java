package cn.itsource.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.awt.*;

@SpringBootApplication
@EnableEurekaClient// eureka的客户端
public class CommonApplication6699 {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication6699.class);
    }
}
