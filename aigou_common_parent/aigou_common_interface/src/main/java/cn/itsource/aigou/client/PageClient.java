package cn.itsource.aigou.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value="COMMON-PROVIDER",fallback = PageFall.class)
public interface PageClient {

    @RequestMapping(value = "/common/page",method = RequestMethod.POST)
    void createPage(@RequestBody Map<String,Object> map);


}
