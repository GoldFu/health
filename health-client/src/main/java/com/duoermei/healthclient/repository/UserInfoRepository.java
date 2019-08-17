package com.duoermei.healthclient.repository;

import com.duoermei.healthclient.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @Description:
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

    UserInfo findByNickName(String nickName);

    UserInfo findUserByPhoneAndIsDelete(String phone, String isDelete);

    UserInfo findUserByPhoneAndPassword(String phone, String password);

    UserInfo findUserByMailboxAndPassword(String mailbox, String password);

    Optional<UserInfo> findUserByUserId(String userId);

}
