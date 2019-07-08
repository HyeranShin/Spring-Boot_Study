package com.hyeran.seminar4.mapper;

import com.hyeran.seminar4.dto.User;
import com.hyeran.seminar4.model.SignUpReq;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
@Mapper
1. Spring IoC 컨테이너에 서비스 Bean으로 등록
2. 해당 인터페이스에 등록된 SQL Annotation을 토대로 실제 SQL문을 실행
3. 3 이상 버전부터 mapper.xml 대신 interface 클래스의 Annotation을 통해 SQL을 사용할 수 있음
4. 가급적 SQL 키워드는 대문자, 나머지는 소문자로 작성하는 것이 가독성이 좋음
5. 서비스(@Service)와 사용 방법은 똑같음
 */
@Mapper
public interface UserMapper {

    /*
    @Select
    1. 조회 Annotation
    2. #{value}으로 동적 바인딩을 처리하고 @Param("value")로 값을 명시
     */

    //모든 회원 리스트 조회
    @Select("SELECT * FROM user")
    List<User> findAll();

    //회원 이름으로 조회
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") final String name);

    //회원 고유 번호로 조회
    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") final int userIdx);

    /*
    @Insert
    1. 데이터 삽입 Annotation
    2. 반환 값으로 AI값을 받아오고 싶으면 @Options Annotation을 이용해 AI 키 값을 명시해줌. 반환 타입은 int(AI 컬럼 타입과 일치)
     */

    //회원 등록, Auto Increment는 회원 고유 번호
    //Auto Increment 값을 받아오고 싶으면 리턴 타입을 int(Auto Increment 컬럼 타입)으로 하면 됨
    @Insert("INSERT INTO user(name, part, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.part}, #{signUpReq.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "userIdx")
    void save(@Param("signUpReq") final SignUpReq signUpReq);

    //Auto Increment 값을 받아오고 싶지 않다면 필요 없음
    @Insert("INSERT INTO user(name, part) VALUES(#{user.name}, #{user.part})")
    void save2(@Param("user") final User user);

    /*
    @Update & @Delete
    수정, 삭제 Annotation
     */

    //회원 정보 수정
    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE userIdx = #{userIdx}")
    void update(@Param("userIdx") final int userIdx, @Param("user") final User user);

    //회원 삭제
    @Delete("DELETE FROM user where userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);

    //이름과 비밀번호로 조회
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User findByNameAndPassword(@Param("name") final  String name, @Param("password") final String password);
}
