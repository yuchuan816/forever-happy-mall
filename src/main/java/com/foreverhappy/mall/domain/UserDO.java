package com.foreverhappy.mall.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liuyuchuan
 * @date 2020/12/29
 */

@Getter
@Setter
@Entity
@Table(name = "fh_user")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_name", length = 32)
    private String userName;

    @Column(name="nike_name", length = 32)
    private String nikeName;

    @Column(name="sex")
    private Integer sex;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;
}
