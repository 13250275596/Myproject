package com.example.myproject.controller;

import com.example.myproject.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.pkcs11.wrapper.Constants;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(description = "用户相关接口文档")
public class SwaggerController {
//    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
//    @ApiOperation(value = "获取用户", notes = "增加用户")
//    public List<User> add() {
//
//        return ;
//
//    }
}
