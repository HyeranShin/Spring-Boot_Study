package com.hyeran.seminar3.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * null 체크
 * NullpointerException
 * Runtime시에 Null Check
 * @NonNull
 * 클래스가 아닌 필드에 붙는 Annotation
 */

@AllArgsConstructor
public class TestNonNull {
    private int userIdx;
    @NonNull
    private String name;
    private String email;

    public TestNonNull() {
        this.name = null;
    }
}
