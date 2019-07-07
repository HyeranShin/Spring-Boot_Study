package com.hyeran.seminar3_report.service;

import com.hyeran.seminar3_report.model.DefaultRes;
import com.hyeran.seminar3_report.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //현재 시간 조회
    DefaultRes<String> getCurrentTime();

    //모든 회원 리스트 조회
    //이름, 파트로 회원 검색
    DefaultRes<List<User>> getUserByNamePart(final Optional<String> name, final Optional<String> part);

    //idx로 회원 검색
    DefaultRes<User> getUserByIdx(final int userIdx);

    //회원 저장
    DefaultRes<List<User>> saveUser(final User user);

    //회원 정보 수정
    DefaultRes<List<User>> updateUserInfo(final int userIdx, final User user);

    //회원 삭제
    DefaultRes<List<User>> deleteUser(final int userIdx);
}
