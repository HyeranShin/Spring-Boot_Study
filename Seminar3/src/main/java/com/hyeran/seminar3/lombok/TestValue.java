package com.hyeran.seminar3.lombok;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.Wither;

/**
 * @Value
 * immutable class 만드는 Annotation
 * 모든 필드를 private final
 * Setter 메소드를 생성하지 않음
 * Final class = 더 이상의 상속 불가능
 * import org.springframework.beans.factory.annotation.Value; 와 다르다!!
 *
 * 1. 모든 필드 값 final
 * 2. Getter 메소드만 자동 생성
 * 3. AllArgsConstructor 자동 생성
 *
 * @Wither
 * 값을 변경한 새로운 객체를 만들어줌
 *
 * @NonFinal
 * 필드의 final을 선언하지 않을 때 사용
 */

@Value
public class TestValue {
    @Wither(AccessLevel.PROTECTED)
    private int userIdx;
    @NonFinal
    private String name;
    private String email;
}
