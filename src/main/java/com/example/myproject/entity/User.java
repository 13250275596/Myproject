package com.example.myproject.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("name")
    private String name;
}
