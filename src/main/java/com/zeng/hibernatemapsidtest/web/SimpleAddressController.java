package com.zeng.hibernatemapsidtest.web;

import com.zeng.hibernatemapsidtest.domain.SimpleAddress;
import com.zeng.hibernatemapsidtest.domain.User;
import com.zeng.hibernatemapsidtest.repo.SimpleAddressRepo;
import com.zeng.hibernatemapsidtest.repo.UserRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zeng
 * @version 1.0.0
 * @date 2020-04-22
 */
@RestController
@RequestMapping("/simpleAddress")
public class SimpleAddressController {
    @Resource
    private SimpleAddressRepo simpleAddressRepo;
    @Resource
    private UserRepo userRepo;

    /**
     * SimpleAddress domain will be OK when create with one to one and mapsId annotation, but
     * HomeAddress will not OK.
     * @return /
     */
    @RequestMapping
    @Transactional
    public SimpleAddress create() {



        User user = new User();
        user.setName(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        userRepo.save(user);

        SimpleAddress simpleAddress = new SimpleAddress();
        simpleAddress.setSimpleAddress("simple address");
        simpleAddress.setUser(user);

        return simpleAddressRepo.save(simpleAddress);
    }
}
