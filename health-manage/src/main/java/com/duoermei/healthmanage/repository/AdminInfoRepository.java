package com.duoermei.healthmanage.repository;

import com.duoermei.healthmanage.model.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @Description:
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
public interface AdminInfoRepository extends JpaRepository<AdminInfo, String>, JpaSpecificationExecutor<AdminInfo> {

    AdminInfo findAdminByPhoneAndIsDelete(String phone, String isDelete);

    AdminInfo findAdminByPhoneAndPassword(String phone, String password);

    AdminInfo findAdminByMailboxAndPassword(String mailbox, String password);

    Optional<AdminInfo> findAdminByAdminId(String adminId);

}
