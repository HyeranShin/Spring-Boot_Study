package com.hyeran.seminar4.dto;

import lombok.Data;

@Data
public class User {
    private int userIdx;
    private String name;
    private String part;
    private String profileUrl;
    private String password;
}
