package com.duoermei.healthclient.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @Description: 钱包明细
 * @Author GoldFu
 * @Date 2019/6/3
 * @Version V1.0
 **/
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class WalletDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 64)
    private String walletDetailId;
    /**
     * 用户id
     */
    @Column(nullable = false, length = 64)
    private String userId;
    /**
     * 对方id
     */
    @Column(nullable = false, length = 64)
    private String otherSideId;
    /**
     * 钱包id
     */
    @Column(nullable = false, length = 64)
    private String walletId;
    /**
     * 金额来源
     */
    @Column(nullable = false, length = 64)
    private String source;
    /**
     * 钱支付状态
     */
    private String payStatus;
    /**
     * 来源描述
     */
    private String sourceDescription;
    /**
     * 积分数
     */
    @Column(nullable = false, length = 64)
    private BigDecimal amount = BigDecimal.ZERO;
    /**
     * 收入/支出
     */
    private String type;

    private String isDelete = "0";

    @Column(nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(nullable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    private Date lastModifiedDate;

    @Column(nullable = false)
    @LastModifiedBy
    private String lastModifiedBy;

    @PrePersist
    public void walletDetailId() {
        walletDetailId = UUID.randomUUID().toString();
    }
}