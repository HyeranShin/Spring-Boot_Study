package com.hyeran.seminar8.repository;

import com.hyeran.seminar8.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    //이름을 입력받아서 삭제
    @Transactional
    void deleteByName(final String name);

    /**
     * Delete 메소드 재정의
     * JPA의 Delete가 내부적으로 find를 한번 하고 삭제를 진행하기 때문에, 재정의
     * @param user_idx : User Resource index
     */
    @Transactional
    @Modifying
    @Query("DELETE User u WHERE u.user_idx = :user_idx")
    void deleteByUserIdx(@Param("user_idx") final int user_idx);

    //이름으로 조회
    //List<Item> findByName(final String name);

    //이름과 비밀번호를 받아서 유저 전환
    //User findByEmailAndPassword(final String name, final String password);
}
