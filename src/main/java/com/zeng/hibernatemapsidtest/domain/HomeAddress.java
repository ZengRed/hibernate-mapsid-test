package com.zeng.hibernatemapsidtest.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zeng
 * @version 1.0.0
 * @date 2020-04-22
 */
@Data
@Entity
public class HomeAddress extends AbsAddress {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String homeAddress;
}
