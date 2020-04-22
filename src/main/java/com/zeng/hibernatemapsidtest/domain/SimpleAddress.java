package com.zeng.hibernatemapsidtest.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zeng
 * @version 1.0.0
 * @date 2020-04-22
 */
@Entity
@Data
public class SimpleAddress {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String simpleAddress;
}
