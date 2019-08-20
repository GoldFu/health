package com.duoermei.healthclient.service;

import com.duoermei.healthcommons.model.UserInfo;

/**
 * @Description: 用户中心的接口
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/

public interface UserInfoService {
    UserInfo findUserByName(String userName);

}
