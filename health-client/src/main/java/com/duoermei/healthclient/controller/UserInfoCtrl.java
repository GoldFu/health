package com.duoermei.healthclient.controller;

import com.duoermei.healthclient.service.FeignAdminService;
import com.duoermei.healthclient.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 用户api入口
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
@RestController
@RequestMapping("user/")
public class UserInfoCtrl {
    @Autowired
    private UserInfoService userInfoService;
//    @Autowired
//    public RestTemplate restTemplate;
    @Autowired
    private FeignAdminService feignAdminService;

    @GetMapping("get")
    public JSONObject findUserByName() throws JSONException {
        //查询当前项目用户名称
        //重新管理员项目 是否存在同一个名称的用户
        Object obj = feignAdminService.findAdminByNickName("张三0");
        JSONObject object = new JSONObject();
       // object.put("user", user);
        object.put("admin", obj);
        return object;
    }

}
