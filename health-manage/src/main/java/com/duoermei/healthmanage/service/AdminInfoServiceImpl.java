package com.duoermei.healthmanage.service;


import com.duoermei.healthmanage.model.AdminInfo;
import com.duoermei.healthmanage.repository.AdminInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 管理员逻辑实现层
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/
@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminInfoRepository adminInfoRepository;



    @Override
    public AdminInfo findAdminByPhoneAndPassword(String phone, String password) {
        return adminInfoRepository.findAdminByPhoneAndPassword(phone, password);
    }

    @Override
    public AdminInfo findAdminByPhoneAndIsDelete(String phone) {
        return adminInfoRepository.findAdminByPhoneAndIsDelete(phone, "0");
    }

    @Override
    public AdminInfo findAdminByMailboxAndPassword(String mailbox, String password) {
        return adminInfoRepository.findAdminByMailboxAndPassword(mailbox, password);
    }

    @Override
    public AdminInfo findAdminByAdminId(String adminId) {
        return null;
    }

    @Override
    public AdminInfo findAdminByNickName(String nickName) {
        return null;
    }

    @Override
    public AdminInfo addAdmin(AdminInfo admin) {
        return null;
    }

    @Override
    public AdminInfo delAdmin(String adminId) {
        return null;
    }

    @Override
    public List<AdminInfo> findAdminRoleId(String roleId) {
        return null;
    }


    @Override
    public List<AdminInfo> findbyadminname(String adminname) {
        return adminInfoRepository.findAll((Specification<AdminInfo>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(adminname)) {
                predicates.add(builder.like(root.get("nickName"), "%" + adminname + "%"));
            }

            predicates.add(builder.equal(root.get("isDelete"), "0"));
            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }


}
