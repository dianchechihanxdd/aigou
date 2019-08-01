package cn.itsource.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //启动配置服务端
public class ConfigApplication8848 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication8848.class);
    }
}
