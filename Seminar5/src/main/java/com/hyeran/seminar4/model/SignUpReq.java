package com.hyeran.seminar4.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@Data
public class SignUpReq {
    private String name;
    private String password;
    private String part;

    //프로필 사진 객체
    private MultipartFile profile;
    //프로필 사진 저장 url 주소
    private String profileUrl;
}
