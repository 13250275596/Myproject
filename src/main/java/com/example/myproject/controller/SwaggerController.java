package com.example.myproject.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
