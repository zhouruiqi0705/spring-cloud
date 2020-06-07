package com.example.springcloud.login.controller;

import com.example.springcloud.common.util.RedisUtil;
import com.example.springcloud.login.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/test")
public class  TestController {


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/getAllUser")
    @ResponseBody
    public Object getAllUser(@RequestBody Map map){
        String id = map.get("id").toString();
        Object o = new Object();
        //判断是否存在key
        boolean is = redisUtil.exists(id);
        if(is){
             o = redisUtil.get(id);
        }else {
            //缓存失效，从数据库读取
            try {
                List list = userService.selectAllUser(map);
                redisUtil.set("ass",list);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return o;
    }
}
