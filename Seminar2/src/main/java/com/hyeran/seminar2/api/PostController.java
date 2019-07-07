package com.hyeran.seminar2.api;

import com.hyeran.seminar2.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post") //Controller 자체에 URL Mapping도 가능
public class PostController {

    /*
    @PostMapping: Post 메소드 전용 Controller Annotation
    리소스를 생성하는 요청에 사용
    @RequestBody: Parameter로 객체를 받는 Annotation
    1. HTTP Message 본문을 자바 객체로 변환(Mapping)
    2. Spring MVC 내의 HttpMessageConverter가 변환 처리
    3. 전송한 객체와 전송 받을 Controller의 객체 타입이 어느 정도 같아야 함
    4. 같지 않으면 값이 자동으로 채워지지 않음
     */
    @PostMapping("")
    public String postUser(@RequestBody final User user) {
        return user.getName();
    }
}
