package com.zeng.hibernatemapsidtest.web;

import com.zeng.hibernatemapsidtest.domain.HomeAddress;
import com.zeng.hibernatemapsidtest.domain.User;
import com.zeng.hibernatemapsidtest.repo.HomeAddressRepo;
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
@RequestMapping("/homeAddress")
public class HomeAddressController {
    @Resource
    private HomeAddressRepo homeAddressRepo;
    @Resource
    private UserRepo userRepo;

    /**
     * HomeAddress domain will be NOT OK when create with one to one and mapsId annotation，
     * because HomeAddress' parent entity use @Inheritance strategy, while SimpleAddress
     * creation will be Ok.
     *
     * @return /
     */
    @RequestMapping
    @Transactional
    public HomeAddress create() {

        User user = new User();
        user.setName(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        userRepo.save(user);

        HomeAddress homeAddress = new HomeAddress();
        homeAddress.setType("HOME");
        homeAddress.setHomeAddress("my home");
        homeAddress.setUser(user);

        /*
         * Here will throw Exception:
         * Referential integrity constraint violation: "FKLBPS9IRLE6VWEQXXGWG1MRXGQ:
         * PUBLIC.HOME_ADDRESS FOREIGN KEY(ID) REFERENCES PUBLIC.USER(ID) (3)";
         */
        return homeAddressRepo.save(homeAddress);
    }
}
