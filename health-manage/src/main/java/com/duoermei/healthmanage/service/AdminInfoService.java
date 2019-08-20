package com.duoermei.healthmanage.service;

import com.duoermei.healthmanage.model.AdminInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description: 管理员逻辑接口层
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/
public interface AdminInfoService {

    AdminInfo findAdminByNickName(String nickName);


    /**
     * 根据手机号，密码查询管理员
     *
     * @param phone
     * @param password
     * @return
     */
    AdminInfo findAdminByPhoneAndPassword(String phone, String password);

    AdminInfo findAdminByPhoneAndIsDelete(String phone);


    /**
     * 根据邮箱，密码查询管理员
     *
     * @param mailbox
     * @param password
     * @return
     */
    AdminInfo findAdminByMailboxAndPassword(String mailbox, String password);

    AdminInfo findAdminByAdminId(String adminId);


    AdminInfo addAdmin(AdminInfo admin);

    AdminInfo delAdmin(String adminId);

    List<AdminInfo> findAdminRoleId(String roleId);


    List<AdminInfo> findbyadminname(String adminname);

}
