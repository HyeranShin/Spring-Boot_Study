package com.hyeran.seminar4.api;

import com.hyeran.seminar4.model.DefaultRes;
import com.hyeran.seminar4.model.LoginReq;
import com.hyeran.seminar4.service.AuthService;
import com.hyeran.seminar4.utils.ResponseMessage;
import com.hyeran.seminar4.utils.StatusCode;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "로그인 REST API")
@Slf4j
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);

    private final AuthService authService;

    public LoginController(final AuthService authService) {
        this.authService = authService;
    }

    /**
     * 로그인
     *
     * @param loginReq 로그인 객체
     * @return ResponseEntity
     */
    @ApiOperation(value = "로그인", notes = "성공시 jwt 토큰을 헤더에 넣어서 반환합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 500, message = "내부 서버 에러")
    })
    @PostMapping("")
    public ResponseEntity login(@RequestBody final LoginReq loginReq) {
        try {
            return new ResponseEntity<>(authService.login(loginReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
