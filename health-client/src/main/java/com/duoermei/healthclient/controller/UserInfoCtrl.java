package com.duoermei.healthclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.duoermei.healthclient.service.FeignAdminService;
import com.duoermei.healthcommons.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private FeignAdminService feignAdminService;

    @GetMapping("get")
    public JSONObject findUserByName() {
        System.out.println("==========================");
        // object.put("admin", obj);
        return ResponseData.success("成功");
    }

}
