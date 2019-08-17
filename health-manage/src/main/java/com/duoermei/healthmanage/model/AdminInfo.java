package com.duoermei.healthmanage.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @Description: 管理员表
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AdminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 24)
    private Integer id;

    // 管理员ID
    @Column(unique = true, nullable = false, length = 36)
    private String adminId;

    // 管理员密码
    @Column(nullable = false, length = 24)
    private String password;
    //工号
    @Column(nullable = false, length = 24)
    private String jobNumber;
    // 管理员姓名
    @Column(nullable = false, length = 36)
    private String nickName;

    @Column(length = 32)
    private String realName;

    @Column(nullable = false, length = 24)
    private String phone;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 是否推荐
     */


    /**
     * 详情
     */
    private String detail;

    @Column(nullable = false, length = 24)
    private String mailbox;

    @Column(length = 36)
    private String avatar;

    private String sex;

    @Column(length = 24)
    private String position;

    @Column(length = 36)
    private String companyId;

    @Column(length = 36)
    private String departmentId;

    @Column(length = 36)
    private String inviteAdminId;

    private String isDelete = "0";

    @Column(nullable = false)
    @CreatedBy
    private String createBy;

    @Column(nullable = false)
    @CreatedDate
    private Date createDate;

    @Column(nullable = false)
    @LastModifiedDate
    private Date lastModifiedDate;

    @Column(nullable = false)
    @LastModifiedBy
    private String lastModifiedBy;

    //权限等级
    @Column(nullable = false)
    private Integer privilegeLevel;

    //取消等级
    private String roleId;

    private String lastPasswordResetDate;

    private String roleName;

    @PrePersist
    public void adminId() {
        adminId = UUID.randomUUID().toString();
    }


}