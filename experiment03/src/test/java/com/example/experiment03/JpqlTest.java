package com.example.experiment03;

import com.example.experiment03.Repository.AddressRepository;
import com.example.experiment03.Repository.UserAddressRepository;
import com.example.experiment03.Repository.UserRepository;
import com.example.experiment03.entity.Address;
import com.example.experiment03.entity.User;
import com.example.experiment03.entity.UserAddress;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JpqlTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Test
    public void init(){
        User user = new User("flj");
        userRepository.save(user);
        User user1 = new User("zk");
        userRepository.save(user1);

        Address address = new Address("748");
        addressRepository.save(address);
        Address address1 = new Address("753");
        addressRepository.save(address1);

        Address address2 = new Address("910");
        addressRepository.save(address2);

        UserAddress userAddress = new UserAddress(user,address);
        userAddressRepository.save(userAddress);

        UserAddress userAddress1 = new UserAddress(user,address1);
        userAddressRepository.save(userAddress1);

        UserAddress userAddress2 = new UserAddress(user1,address2);
        userAddressRepository.save(userAddress2);
    }

    /*public void addressTest(){
        addressRepository.list("748").forEach(a->{
            log.debug("{}",a.getId());
        });
    }*/
    @Test
    public void userRepTest() {
        User user = userRepository.find(1);
        log.debug(user.getName());
    }
    @Test
    public void addressRepTest() {
        addressRepository.list("748")
                .forEach(a -> {
                    log.debug("{}", a.getId());
                    });
    }

    @Test
    public void userAddressRepTest() {
        UserAddress ua = userAddressRepository.find("flj", "748");
        log.debug("插入时间：{}", ua.getInsertTime());
        System.out.println(ua.getInsertTime());
    }




}
