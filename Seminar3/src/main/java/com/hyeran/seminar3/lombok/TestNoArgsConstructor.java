package com.hyeran.seminar3.lombok;

import lombok.NoArgsConstructor;

/**
 * @NoArgsContructor
 * Default 생성자 자동 생성
 */
@NoArgsConstructor
public class TestNoArgsConstructor {
    private int userIdx;
    private String name;
    private String email;

    //Default 생성자 자동 생성
    //public TestNoArgsConstructor() { }
}
