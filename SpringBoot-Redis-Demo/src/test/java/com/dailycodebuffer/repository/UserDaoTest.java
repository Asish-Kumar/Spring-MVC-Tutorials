package com.dailycodebuffer.repository;

import com.dailycodebuffer.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataRedisTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class))
//@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testSave(){
        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setFirstName("D");
        savedUser.setLastName("J");
        savedUser.setEmailId("dj@DJ.com");
        savedUser.setAge(22);

        userDao.saveUser(savedUser);

        User retrivedUser = userDao.fetchUserById(1L);

        Assert.assertEquals(savedUser, retrivedUser);
    }
}
