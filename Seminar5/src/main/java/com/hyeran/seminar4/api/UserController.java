package com.hyeran.seminar4.api;

import com.hyeran.seminar4.model.SignUpReq;
import com.hyeran.seminar4.service.JwtService;
import com.hyeran.seminar4.service.UserService;
import com.hyeran.seminar4.utils.auth.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.hyeran.seminar4.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Auth
    @GetMapping("")
    public ResponseEntity getUser(
            @RequestHeader("Authorization") final String header,
            @RequestParam("name") final Optional<String> name) {
        try {
            log.info("ID : " + jwtService.decode(header));
            //name이 null일 경우 false, null이 아닐 경우 true
            if(name.isPresent())  {
                return new ResponseEntity<>(userService.findByName(name.get()), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity signUp(SignUpReq signUpReq, @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        log.error("signUp 함수 진입");
        try {
            log.error("signUp 함수 내 try 진입");
            //파일을 signUpReq에 저장
            if(profile != null) {
                log.error("사진 파일 있음");
                signUpReq.setProfile(profile);
            }
            else log.error("사진 파일 없음");
            return new ResponseEntity<>(userService.save(signUpReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 수정 API
     * 인증 필요
     * @param userIdx   회원 고유 번호
     * @param signUpReq 수정할 회원 정보 객체
     * @return
     */
    @Auth
    @PutMapping("/{userIdx}")
    public ResponseEntity signUp(
            @PathVariable(value = "userIdx") final int userIdx,
            SignUpReq signUpReq,
            @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        try {
            if(profile != null) signUpReq.setProfile(profile);
            return new ResponseEntity<>(userService.update(userIdx, signUpReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 정보 삭제 API
     * 인증 필요
     * @param userIdx 회원 고유 번호
     * @return ResponseEntity
     */
    @Auth
    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable("userIdx") final int userIdx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
