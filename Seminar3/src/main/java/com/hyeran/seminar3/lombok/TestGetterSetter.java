package com.hyeran.seminar3.lombok;

import lombok.Getter;
import lombok.Setter;

/**
 * @Getter
 * Getter 메소드 자동 생성
 *
 * @Setter
 * Setter 메소드 자동 생성
 */
@Getter
@Setter
public class TestGetterSetter {
    private int userIdx;
    private String name;
    private String email;
}
