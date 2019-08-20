package com.duoermei.healthdoctor.controller;

import com.alibaba.fastjson.JSONObject;
import com.duoermei.healthcommons.model.Doctor;
import com.duoermei.healthcommons.utils.ResponseData;
import com.duoermei.healthdoctor.service.DoctorService;
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
public class DoctorCtrl {
    @Autowired
    private DoctorService DoctorService;

    @GetMapping("get")
    private JSONObject add() {
        Doctor doctor=new Doctor();
        doctor.setAvatar("都行");
        return ResponseData.success(doctor);
    }


}
