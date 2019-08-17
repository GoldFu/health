package com.duoermei.healthdoctor.service;

import com.duoermei.healthdoctor.model.Doctor;
import com.duoermei.healthdoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户中心接口实现
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor findUserByName(String userName) {
        return doctorRepository.findByNickName(userName);
    }

}
