package com.duoermei.healthclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 用户详情
 * @Author GoldFu
 * @Date 2019/6/3
 * @Version V1.0
 **/
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 36)
    private String userId;

    @Column(unique = true, nullable = false, length = 36)
    private String userInfoId;
    /**
     * 唯一账户
     */
    @Column(unique = true, nullable = false, length = 36)
    private String account;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 地址
     */
    private String address;
    /**
     * 身份
     */
    private String identity;
    /**
     * 学校
     */
    private String school;
    /**
     * 年级
     */
    private String grade;
    /**
     * 科目
     */
    private String subject;
    /**
     * 相关证书
     */

    /**
     * 认证审核
     */
    private String review;
    /**
     * 认证状态
     */

    /**
     * 认证描述
     */
    private String certificationDescription;

    /**
     * 是否禁用
     */

    /**
     * 省code
     */
    private String provDivisionCode = "";
    /**
     * 省份
     */
    private String province = "";
    /**
     * 市code
     */
    private String cityDivisionCode = "";

    private String city = "";
    /**
     * 镇code
     */
    private String townDivisionCode = "";
    /**
     * 镇
     */
    private String town = "";
    /**
     * 详细地址
     */
    private String addressDetail = "";
    /**
     * 完整的地址
     */
    private String fullAddress = "";

    private String isDelete = "0";

    @Column(nullable = false)
    @CreatedBy
    private String createBy;

    @Column(nullable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    private Date lastModifiedDate;

    @Column(nullable = false)
    @LastModifiedBy
    private String lastModifiedBy;


    /**
     * 短信提醒
     */
    private String isSmsremind = "0";


    /**
     * APP提醒
     */
    private String isAppremind = "0";

    /**
     * 站内信提醒
     */
    private String isLetterremind = "0";
    /**
     * 推送ID
     */
    private String cid;

    @PrePersist
    public void userInfoId() {
        userInfoId = UUID.randomUUID().toString();
    }
}
