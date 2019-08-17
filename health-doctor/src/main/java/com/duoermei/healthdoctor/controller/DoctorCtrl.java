package com.duoermei.healthdoctor.controller;

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


}
