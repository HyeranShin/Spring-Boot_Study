package com.hyeran.seminar3.service.impl;

import com.hyeran.seminar3.model.DefaultRes;
import com.hyeran.seminar3.model.User;
import com.hyeran.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Service
 * 1. Business Logic 중에서 애플리케이션에서 사용할 수 있게 컴포넌트(부품화)한 부분을 Servie Layer라고 함
 * 2. Bean으로 등록해 언제, 어디서든 사용할 수 있는 Class(재사용)
 * 3. @Service: Spring IoC 컨테이너에서 서비스 Bean으로 등록
 */
@Service
public class UserServiceImpl implements UserService {

    private static final List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAll() {
        if(userList.isEmpty()) {
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트가 비었습니다.");
        }
        else {
            return DefaultRes.res(HttpStatus.OK.value(), "리스트 조회 성공", userList);
        }
    }

    @Override
    public DefaultRes<User> findByUserIdx(int userIdx) {
        return null;
    }

    @Override
    public DefaultRes save(User user) {
        return null;
    }

    @Override
    public DefaultRes<User> update(int userIdx, User user) {
        return null;
    }

    @Override
    public DefaultRes deleteByUserIdx(int userIdx) {
        return null;
    }
}
