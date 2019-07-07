package com.hyeran.seminar3.lombok;

import lombok.Builder;

/**
 * @Builder
 * Builder 클래스 및 메소드 자동 생성
 * Inner Class로 Builder 클래스 생성
 */

@Builder
public class TestBuilder {
    private int userIdx;
    private String name;
    private String email;
}
