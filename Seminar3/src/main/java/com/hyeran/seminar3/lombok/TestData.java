package com.hyeran.seminar3.lombok;

import lombok.Data;

/**
 * @Data
 * 모든 메소드 자동 생성
 * @Setter
 * @Getter
 * @ToString
 * @EqualsAndHashCode
 * @NoArgsConstructor
 *
 * 만능 Annotation이지만 사용하지 않는 메소드까지 만들어주므로 사용시 고민할 필요가 있음
 * Builder 클래스까지는 자동으로 만들어 주지 않음
 */

@Data
public class TestData {
    private int userIdx;
    private String name;
    private String email;
}
