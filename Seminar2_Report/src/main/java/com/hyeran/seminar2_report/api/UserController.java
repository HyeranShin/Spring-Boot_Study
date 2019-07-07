package com.hyeran.seminar2_report.api;

import com.hyeran.seminar2_report.model.User;
import org.springframework.web.bind.annotation.*;
import sun.awt.image.ImageWatched;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {

    private final static List<User> userList = new LinkedList<>();

    User user1 = new User(1, "신혜", "안드로이드");
    User user2 = new User(2, "이승아", "디자인");
    User user3 = new User(3, "박찬인", "서버");
    User user4 = new User(4, "송아영", "안드로이드");

    User none = new User(-1, "없습니다", "없습니다");

    /**
     * 현재 시간 조회
     * @return 현재 시간
     */
    @GetMapping("/")
    public String getCurrentTime() {
        Long timeLong = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
        String time = dateFormat.format(new Date(timeLong));
        return time;
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
    public List<User> getUserByNamePart(
            @RequestParam(value = "name", defaultValue = "") final String name,
            @RequestParam(value = "part", defaultValue = "") final String part
    ) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        if(name.isEmpty() && part.isEmpty()) {
            return userList;
        }
        else {
            List<User> searchUserList = new LinkedList<>();
            for (User u : userList) {
                if (u.getName() == name) {
                    searchUserList.add(u);
                }
                if (u.getPart() == part) {
                    searchUserList.add(u);
                }
            }

            if(searchUserList.isEmpty()) {
                searchUserList.add(none);
            }
            return searchUserList;
        }
    }

    /**
     * idx로 회원 검색
     * @param userIdx
     * @return 해당 회원
     */
    @GetMapping("/users/{user_idx}")
    public User getUserByIdx(@PathVariable(value = "user_idx") final int userIdx) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        for(User u : userList) {
            if(u.getUser_idx() == userIdx) {
                return u;
            }
        }

        userList.add(none);
        return userList.get(userList.size()-1);
    }


    /**
     * 회원 저장
     * @param user
     * @return 추가된 회원 리스트
     */
    @PostMapping("/users")
    public List<User> saveUser(@RequestBody final User user) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        userList.add(user);

        return userList;
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     * @param user
     * @return 수정된 회원 리스트
     */
    @PutMapping("/users/{user_idx}")
    public List<User> updateUserInfo(
            @PathVariable(value = "user_idx") final int userIdx,
            @RequestBody final User user
    ) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        for(User u : userList) {
            if(u.getUser_idx() == userIdx) {
                userList.remove(u);
            }
        }

        userList.add(user);
        return userList;
    }

    /**
     * 회원 삭제
     * @param userIdx
     * @return 삭제 후 회원 리스트
     */
    @DeleteMapping("/users/{user_idx}")
    public List<User> deleteUser(@PathVariable(value = "user_idx") final int userIdx) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        for(User u : userList) {
            if(u.getUser_idx() == userIdx) {
                userList.remove(u);
            }
        }

        return userList;
    }
}
