package com.hyeran.seminar4.api;

import com.hyeran.seminar4.dto.User;
import com.hyeran.seminar4.model.SignUpReq;
import com.hyeran.seminar4.service.JwtService;
import com.hyeran.seminar4.service.UserService;
import com.hyeran.seminar4.utils.auth.Auth;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.hyeran.seminar4.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @ApiOperation(value = "회원 조회", notes = "성공시 회원 리스트를 반환합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "이름", dataType = "string", paramType = "query", defaultValue = ""),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원 조회 성공"),
            @ApiResponse(code = 500, message = "내부 서버 에러")
    })
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

    @ApiOperation(value = "회원 가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "이름", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "part", value = "파트", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "password", value = "비밀번호", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원 가입 성공"),
            @ApiResponse(code = 500, message = "내부 서버 에러")
    })
    @PostMapping("")
    public ResponseEntity signUp(SignUpReq signUpReq) {
        log.error("signUp 함수 진입");
        try {
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
    @ApiOperation(value = "회원 정보 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원 정보 수정 성공"),
            @ApiResponse(code = 500, message = "내부 서버 에러")
    })
    @Auth
    @PutMapping("/{userIdx}")
    public ResponseEntity update(
            @RequestHeader("Authorization") final String header,
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
    @ApiOperation(value = "회원 탈퇴")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원 탈퇴 성공"),
            @ApiResponse(code = 500, message = "내부 서버 에러")
    })
    @Auth
    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(
            @RequestHeader("Authorization") final String header,
            @PathVariable("userIdx") final int userIdx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
