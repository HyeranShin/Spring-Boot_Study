package com.hyeran.seminar3.lombok;

import lombok.AllArgsConstructor;

/**
 * @AllArgsConstructor
 * 모든 필드의 생성자 자동 생성
 */

@AllArgsConstructor
public class TestAllArgsConstructor {
    private int userIdx;
    private String name;
    private String email;

    //모든 필드의 생성자 자동 생성
//    public TestAllArgsConstructor(final int userIdx, final String name, final String email) {
//        this.userIdx = userIdx;
//        this.name = name;
//        this.email = email;
//    }
}
