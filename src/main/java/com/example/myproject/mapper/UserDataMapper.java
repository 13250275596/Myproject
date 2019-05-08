package com.example.myproject.mapper;

import com.example.myproject.dto.res.UserParam;
import com.example.myproject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserDataMapper {

    @Select("<script>select * from user " +
            "<where>" +
            "<if test= 'user.id !=null and user.id !=0 '> id = #{user.id} </if>" +
            "<if test= 'user.name !=null and user.name != \"\"'> and name = #{user.name}</if>" +
            "</where>" +
            "</script>")
    User getUserBy(@Param("user") UserParam user);

    @SelectProvider(type = UserDataProvider.class,method = "getAllUsers")
    List<User> getAllUsers();

    @Select(
            "<script>" +
                    "select * from user" +
                    "<where>" +
                    "#{userparam.id} in " +
                    "<foreach item='id' index='index' collection='users' open='(' separator=',' close=')'>id</foreach>" +
                    "<if test='userparam.id != null and userparam.id != 0'> and id = #{userparam.id}</if>" +
                    "<if test='userparam.name != null and userparam.name != \"\"'> and name = #{userparam.name}</if>" +
                    "</where>" +
                    "</script>"
    )
    User isUser(@Param("userparam")UserParam userParam,List<Integer> users);

    /**
     *找出所有用户的ID
     */
    @Select("select id from user")
    List<Integer> getAllId();
}
