package com.hyeran.seminar3.api;

import com.hyeran.seminar3.model.DefaultRes;
import com.hyeran.seminar3.model.User;
import com.hyeran.seminar3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  //로그
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * 생성자가 1개일 경우 @Autowired 생략 가능
     * 생성자라 여러 개일 경우 각 생성자에 @Autowired를 붙여야 함
     * @param userService user 서비스
     */
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getAllUsers() {
        log.info("get All Users");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
