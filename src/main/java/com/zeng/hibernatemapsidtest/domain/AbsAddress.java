package com.zeng.hibernatemapsidtest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author zeng
 * @version 1.0.0
 * @date 2020-04-22
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbsAddress {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String type;
}
