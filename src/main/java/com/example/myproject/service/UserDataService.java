package com.example.myproject.service;

import com.example.myproject.dto.res.UserParam;
import com.example.myproject.entity.User;
import com.example.myproject.mapper.AbstractService;
import com.example.myproject.mapper.UserDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserDataService extends AbstractService<UserDataMapper> {

    @Transactional
    public List<User> getAllUsers(){
        return this.mapper.getAllUsers();
    };

    @Transactional
    public User getUserBy(UserParam user){
        return this.mapper.getUserBy(user);
    }

    @Transactional
    public User isUser(UserParam userParam){
        List<Integer> ids = this.mapper.getAllId();
        return this.mapper.isUser(userParam,ids);
    }
}
