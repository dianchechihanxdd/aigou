package cn.itsource.aigou.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="COMMON-PROVIDER",fallback = RedisFall.class)
public interface RedisClient {

    /**
     * post参数接受：
     *
     * RequestParam:请求参数
     * @param key
     * @param value
     */
    @RequestMapping(value = "/redis/set",method = RequestMethod.POST)
    void setRedis(@RequestParam("key") String key,@RequestParam("value") String value);


    //获取
    @RequestMapping(value = "/redis/get/{key}",method = RequestMethod.GET)
    String getRedis(@PathVariable("key") String key);
}
