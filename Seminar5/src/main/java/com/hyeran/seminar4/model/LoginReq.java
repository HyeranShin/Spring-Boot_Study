package com.hyeran.seminar4.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginReq {
    @ApiModelProperty(example = "신혜란")
    private String name;
    @ApiModelProperty(example = "hyeran")
    private String password;
}
