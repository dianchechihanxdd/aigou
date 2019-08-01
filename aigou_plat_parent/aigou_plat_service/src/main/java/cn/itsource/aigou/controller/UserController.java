package cn.itsource.aigou.controller;

import cn.itsource.aigou.domain.User;
import cn.itsource.aigou.util.AjaxResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController// 相当于：controller和每一个方法上有ResponseBody
@RequestMapping("/user")
public class UserController {

    //登录是表单的提交：一般用的post  用于接受post的请求参数：@RequestBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){
        //登录的逻辑：模拟一下service：直接在前台判断，为了安全，后台也要做必要的判断
        if(user!=null&& !StringUtils.isEmpty(user.getName())&&!StringUtils.isEmpty(user.getPwd())){
            String name = user.getName();
            String pwd = user.getPwd();
            if("admin".equals(name)&&"xxx".equals(pwd)){
                return AjaxResult.me();
            }
        }
        return  AjaxResult.me().setSuccess(false).setMsg("登录失败!!!");
    }

    // /user/login2
    @RequestMapping(value = "/login2",method = RequestMethod.GET)
    public AjaxResult login(){
        System.out.println("9999999999999999999999");
        return  AjaxResult.me().setSuccess(false).setMsg("登录失败!!!");
    }
}
