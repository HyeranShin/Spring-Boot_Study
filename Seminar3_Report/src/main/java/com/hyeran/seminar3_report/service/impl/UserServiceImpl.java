package com.hyeran.seminar3_report.service.impl;

import com.hyeran.seminar3_report.model.DefaultRes;
import com.hyeran.seminar3_report.model.User;
import com.hyeran.seminar3_report.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final static List<User> userList = new LinkedList<>();

    User user1 = new User(1, "신혜란", "안드로이드");
    User user2 = new User(2, "이승아", "디자인");
    User user3 = new User(3, "박찬인", "서버");
    User user4 = new User(4, "송아영", "안드로이드");

    @Override
    public DefaultRes<String> getCurrentTime() {
        Long timeLong = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
        String time = dateFormat.format(new Date(timeLong));
        return DefaultRes.res(HttpStatus.OK.value(), "현재 시간 조회 성공", time);
    }

    @Override
    public DefaultRes<List<User>> getUserByNamePart(Optional<String> name, Optional<String> part) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        List<User> result = new LinkedList<>();

        log.info("name: "+name.get());
        log.info("part: "+part.get());

        if(name.get().isEmpty() && part.get().isEmpty()) {
            result = userList;
            return DefaultRes.res(HttpStatus.OK.value(), "모든 회원 조회 성공", result);
        }
        else {
            if (!name.get().isEmpty() && !part.get().isEmpty()) {
                for (User u : userList) {
                    if (u.getName().equals(name.get())) {
                        if(u.getPart().equals(part.get())) {
                            result.add(u);
                        }
                    }
                }
            }
            else {
                if (!name.get().isEmpty()) {
                    log.info(name.toString());
                    log.info(name.get() + "이름 검색");
                    for (User u : userList) {
                        log.info(u.getName());
                        if (u.getName().equals(name.get())) {
                            log.info("이름 일치");
                            result.add(u);
                        }
                    }
                }
                if (!part.get().isEmpty()) {
                    log.info("파트 검색");
                    for (User u : userList) {
                        if (u.getPart().equals(part.get())) {
                            result.add(u);
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "이름/파트 검색 결과 없음");
            } else {
                return DefaultRes.res(HttpStatus.OK.value(), "이름/파트 검색 결과 조회 성공", result);
            }
        }
    }

    @Override
    public DefaultRes<User> getUserByIdx(int userIdx) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        for(User u : userList) {
            if(u.getUser_idx() == userIdx) {
                return DefaultRes.res(HttpStatus.OK.value(), "회원 ID 검색 결과 조회 성공", u);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원 ID 검색 결과 없음");
    }

    @Override
    public DefaultRes<List<User>> saveUser(User user) {
        if(userList.isEmpty()) {
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);
            userList.add(user4);
        }

        userList.add(user);

        return DefaultRes.res(HttpStatus.OK.value(), "회원 저장 성공", userList);
    }

    @Override
    public DefaultRes<List<User>> updateUserInfo(int userIdx, User user) {
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

        return DefaultRes.res(HttpStatus.OK.value(), "회원 정보 수정 성공", userList);
    }

    @Override
    public DefaultRes<List<User>> deleteUser(int userIdx) {
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

        return DefaultRes.res(HttpStatus.OK.value(), "회원 정보 삭제 성공", userList);
    }
}