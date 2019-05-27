package com.example.myproject.controller;

import com.example.myproject.dto.res.UserParam;
import com.example.myproject.entity.StaticThreadPool;
import com.example.myproject.entity.User;
import com.example.myproject.service.UserDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.StreamPrintService;

@RestController
@RequestMapping("")
@Api(description = "测试接口")
public class mainController {

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value = "/checkThreadLocal", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("/checkThreadLocal")
    public User testThreadLocal(@RequestParam("id") int id) {
        User user = userDataService.getUserById(id);
        // StaticThreadPool.threadPool.set("String.valueOf(id)");
        // System.out.print(StaticThreadPool.threadPool.get());
        return user;
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("/getUserById")
    public User getUserById(@Param("id") int id) {
        User user = userDataService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "/getHeader", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("/getHeader")
    public List<String> getHost(@RequestHeader("host") String host, @RequestHeader("Accept") String acceptType,
            @RequestHeader("Accept-Language") String acceptLang, @RequestHeader("Accept-Encoding") String acceptEnc,
            @RequestHeader("Cache-Control") String cacheCon, @RequestHeader("Cookie") String cookie,
            @RequestHeader("User-Agent") String userAgent) {
        List<String> list = new ArrayList<>();
        list.add(host);
        list.add(acceptType);
        list.add(acceptLang);
        list.add(acceptEnc);
        list.add(cacheCon);
        list.add(cookie);
        list.add(userAgent);
        return list;
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("/getuser")
    public User getUserById(@RequestBody UserParam user) {
        return userDataService.getUserBy(user);
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "/getusers")
    public List<Map<String, Object>> getAllUser() {
        // List<User> users = userDataService.getAllUsers();
        List<Map<String, Object>> users = userDataService.getUserMap();
        return users;
    }

    @RequestMapping(value = "/isUser", method = RequestMethod.POST)
    @ApiOperation(value = "/isUser")
    public String isUser(@RequestBody UserParam userParam) {
        StringBuilder sb = new StringBuilder();
        User user = userDataService.isUser(userParam);
        if (user == null)
            sb.append("NO");
        else
            sb.append("YES");

        return sb.toString();
    }

}
