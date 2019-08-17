package com.duoermei.healthclient.service;

import com.duoermei.healthclient.model.UserInfo;
import com.duoermei.healthclient.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户中心接口实现
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findUserByName(String userName) {
        return userInfoRepository.findByNickName(userName);
    }

}
