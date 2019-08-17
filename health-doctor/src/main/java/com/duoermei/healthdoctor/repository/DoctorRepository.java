package com.duoermei.healthdoctor.repository;

import com.duoermei.healthdoctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @Description:
 * @Author GoldFu
 * @Date 2019/8/16
 * @Version V1.0
 **/
public interface DoctorRepository extends JpaRepository<Doctor, String>, JpaSpecificationExecutor<Doctor> {

    Doctor findByNickName(String nickName);

    Doctor findUserByPhoneAndIsDelete(String phone, String isDelete);

    Doctor findUserByPhoneAndPassword(String phone, String password);

    Doctor findUserByMailboxAndPassword(String mailbox, String password);

    Optional<Doctor> findUserByUserId(String userId);

}
