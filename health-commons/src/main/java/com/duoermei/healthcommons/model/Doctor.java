package com.duoermei.healthcommons.model;

import com.duoermei.healthcommons.enumeration.Sex;
import com.duoermei.healthcommons.enumeration.YesOrNo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @Description: 医生详情
 * @Author GoldFu
 * @Date 2019/6/3
 * @Version V1.0
 **/
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 120, unique = true)
    private String doctorId;
    /**
     * 简介
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String introduction;
    /**
     * 背景介绍
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String backgroundIntroduction;
    /**
     * 名字第一字母
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String nameFirstLetter;
    /**
     * 昵称
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String nickName;
    /**
     * 邮箱
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String email;
    /**
     * 身份证号
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String idNumber;
    /**
     * 手机号
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String phone;
    /**
     * 联系电话
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String relationPhone;

    /**
     * 头像
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String avatar;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 真实姓名
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String realName;
    /**
     * qq号
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String qq;
    /**
     * 微信号
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String weChat;
    /**
     * 性别
     */
    @Enumerated(value = EnumType.STRING)
    private Sex sex;
    /**
     * 生日
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 国籍
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String nationality;
    /**
     * 省code
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String provDivisionCode;
    /**
     * 省份
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String province;
    /**
     * 市code
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String cityDivisionCode;
    /**
     * 市
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String city;
    /**
     * 镇code
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String townDivisionCode;
    /**
     * 镇
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String town;
    /**
     * 详细地址
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String addressDetail;
    /**
     * 完整的地址
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String fullAddress;

    /**
     * 是否已认证
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String certification;
    /**
     * 设备唯一标识
     */
    @Column(nullable = false, length = 120, columnDefinition = "")
    private String equipmentIdentity;
    /**
     * 是否删除
     */
    @Enumerated(value = EnumType.STRING)
    private YesOrNo isDelete;
    /**
     * 是否被禁用
     */
    @Enumerated(value = EnumType.STRING)
    private YesOrNo disable;

    @Column(nullable = false, length = 120)
    @CreatedBy
    private String createdBy;

    @Column(nullable = false, length = 120)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false, length = 120)
    @LastModifiedDate
    private Date lastModifiedDate;

    @Column(nullable = false, length = 120)
    @LastModifiedBy
    private String lastModifiedBy;

    @PrePersist
    public void doctorId() {
        doctorId = UUID.randomUUID().toString();
    }
}
