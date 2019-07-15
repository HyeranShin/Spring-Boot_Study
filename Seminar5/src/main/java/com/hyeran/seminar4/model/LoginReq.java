package com.hyeran.seminar4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Login Request Dto : 로그인 내용", description = "로그인 내용")
@Data
public class LoginReq {
    @ApiModelProperty(value = "이름", example = "신혜란")
    private String name;
    @ApiModelProperty(value = "비밀번호", example = "hyeran")
    private String password;
}
