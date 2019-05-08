package com.example.myproject.controller;

import com.example.myproject.dto.res.UserParam;
import com.example.myproject.entity.User;
import com.example.myproject.service.UserDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@Api(description = "测试接口")
public class mainController {

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value = "/getuser",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("/getuser")
    public User getUserById(@RequestBody UserParam user){
        return userDataService.getUserBy(user);
    }

    @RequestMapping(value = "/getusers",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "/getusers")
    public List<User> getAllUser(){
        List<User> users = userDataService.getAllUsers();
        return users;
    }

    @RequestMapping(value = "/isUser",method = RequestMethod.POST)
    @ApiOperation(value = "/isUser")
    public String isUser(@RequestBody UserParam userParam){
        StringBuilder sb = new StringBuilder();
        User user = userDataService.isUser(userParam);
        if(user==null)sb.append("NO");
        else sb.append("YES");

        return sb.toString();
    }


}
