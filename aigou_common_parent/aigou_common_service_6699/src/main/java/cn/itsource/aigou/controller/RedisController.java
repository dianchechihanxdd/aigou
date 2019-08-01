package cn.itsource.aigou.controller;

import cn.itsource.aigou.client.RedisClient;
import cn.itsource.aigou.util.RedisUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController  implements RedisClient{
    @Override
    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public void setRedis(@RequestParam("key") String key, @RequestParam("value") String value) {

        //Redis的set方法：
        RedisUtil.set(key,value);
    }

    @Override
    @RequestMapping(value = "/get/{key}",method = RequestMethod.GET)
    public String getRedis(@PathVariable("key") String key) {
        //Redis的get方法：
        return RedisUtil.get(key);
    }
}
