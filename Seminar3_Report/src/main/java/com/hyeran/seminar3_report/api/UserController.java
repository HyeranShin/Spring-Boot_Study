package com.hyeran.seminar3_report.api;

import com.hyeran.seminar3_report.model.User;
import com.hyeran.seminar3_report.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //여기서는 무조건 상태코드에 200을 넣어서 실패 시 뭐가 문젠지 클라가 볼 수 있도록


    /**
     * 현재 시간 조회
     * @return 현재 시간
     */
    @GetMapping("/")
    public ResponseEntity getCurrentTime() {
        return new ResponseEntity<>(userService.getCurrentTime(), HttpStatus.OK);
    }

    /**
     * 모든 회원 리스트 조회
     * @return 회원 리스트
     *
     * 이름, 파트로 회원 검색
     * @param name
     * @param part
     * @return 해당 회원
     */
    @GetMapping("/users")
    public ResponseEntity getUserByNamePart(
            @RequestParam(value = "name", defaultValue = "") final Optional<String> name,
            @RequestParam(value = "part", defaultValue = "") final Optional<String> part
    ) {
        return new ResponseEntity<>(userService.getUserByNamePart(name, part), HttpStatus.OK);
    }

    /**
     * idx로 회원 검색
     * @param userIdx
     * @return 해당 회원
     */
    @GetMapping("/users/{user_idx}")
    public ResponseEntity getUserByIdx(@PathVariable(value = "user_idx") final int userIdx) {
        return new ResponseEntity<>(userService.getUserByIdx(userIdx), HttpStatus.OK);
    }


    /**
     * 회원 저장
     * @param user
     * @return 추가된 회원 리스트
     */
    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody final User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     * @param user
     * @return 수정된 회원 리스트
     */
    @PutMapping("/users/{user_idx}")
    public ResponseEntity updateUserInfo(
            @PathVariable(value = "user_idx") final int userIdx,
            @RequestBody final User user
    ) {
        return new ResponseEntity<>(userService.updateUserInfo(userIdx, user), HttpStatus.OK);
    }

    /**
     * 회원 삭제
     * @param userIdx
     * @return 삭제 후 회원 리스트
     */
    @DeleteMapping("/users/{user_idx}")
    public ResponseEntity deleteUser(@PathVariable(value = "user_idx") final int userIdx) {
        return new ResponseEntity<>(userService.deleteUser(userIdx), HttpStatus.OK);
    }
}
