package com.duoermei.healthdoctor.service;


import com.duoermei.healthcommons.model.Doctor;

/**
 * @Description: 医生中心的接口
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/

public interface DoctorService {
    Doctor findUserByName(String userName);

}
