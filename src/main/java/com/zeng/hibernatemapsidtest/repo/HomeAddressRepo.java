package com.zeng.hibernatemapsidtest.repo;

import com.zeng.hibernatemapsidtest.domain.HomeAddress;
import com.zeng.hibernatemapsidtest.domain.SimpleAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zeng
 * @version 1.0.0
 * @date 2020-04-22
 */
@Repository
public interface HomeAddressRepo extends JpaRepository<HomeAddress, Long> {
}
