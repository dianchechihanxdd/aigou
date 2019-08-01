package cn.itsource.aigou.controller;

import cn.itsource.aigou.client.PageClient;
import cn.itsource.aigou.util.AiGouConstants;
import cn.itsource.aigou.util.VelocityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/common")
public class PageController implements PageClient{

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @Override
    public void createPage(@RequestBody Map<String, Object> map) {
        //获取参数：
        //调用封装的工具类：
        Object model=map.get(AiGouConstants.PAGE_MODEL);
        String templateFilePathAndName=(String)map.get(AiGouConstants.PAGE_TEMPLATEFILEPATHANDNAME);
        String targetFilePathAndName=(String)map.get(AiGouConstants.PAGE_TARGETFILEPATHANDNAME);
        System.out.println("model:"+model);
        System.out.println("templateFilePathAndName:"+templateFilePathAndName);
        System.out.println("targetFilePathAndName:"+targetFilePathAndName);
        VelocityUtils.staticByTemplate(model,templateFilePathAndName,targetFilePathAndName);
    }
}
