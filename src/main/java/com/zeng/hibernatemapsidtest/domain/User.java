package com.zeng.hibernatemapsidtest.domain;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author zeng
 * @version 1.0.0
 * @date 2020-04-22
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
