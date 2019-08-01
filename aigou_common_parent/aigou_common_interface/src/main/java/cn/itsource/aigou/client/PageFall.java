package cn.itsource.aigou.client;

import cn.itsource.aigou.client.PageClient;
import cn.itsource.aigou.client.RedisClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PageFall implements FallbackFactory<PageClient> {

    @Override
    public PageClient create(Throwable throwable) {
        return new PageClient() {
            @Override
            public void createPage(Map<String, Object> map) {

            }
        };
    }
}
