package com.hyeran.seminar3_report.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    //회원 고유번호
    private int user_idx;
    //회원 이름
    private String name;
    //회원 파트
    private String part;
}
