package com.duoermei.healthcommons.model;

import com.duoermei.healthcommons.enumeration.YesOrNo;
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
 * @Description: 钱包表设计
 * @Author GoldFu
 * @Date 2019/6/3
 * @Version V1.0
 **/
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class DoctorWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 36)
    private String walletId;
    /**
     * 用户id
     */
    @Column(unique = true, nullable = false, length = 36)
    private String doctorId;

    /**
     * 可用金额
     */
    private BigDecimal availableAmount = BigDecimal.ZERO;
    /**
     * 总金额
     */
    @Column(nullable = false, length = 24)
    private BigDecimal totalAmount = BigDecimal.ZERO;
    /**
     * 上一次余额
     */
    @Column(nullable = false, length = 24)
    private BigDecimal lastAmount = BigDecimal.ZERO;
    /**
     * 支付密码
     */
    @Column(columnDefinition = "")
    private String payPassword;
    /**
     * 是否删除
     */
    @Enumerated(value = EnumType.STRING)
    private YesOrNo isDelete;

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
    public void walletId() {
        walletId = UUID.randomUUID().toString();
    }
}
