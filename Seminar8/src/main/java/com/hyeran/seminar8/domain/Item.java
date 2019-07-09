package com.hyeran.seminar8.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
//Spring Data JPA를 위한 Annotaion
@Entity
//JPA 테이블 이름 명시. DB의 테이블 이름과 다를 경우 명시를 통해 매핑 가능
@Table(name = "item")
public class Item {

    //기본키 Annotation
    @Id
    //기본키 자동 생성. 기본키 생성을 DB에 맡김
    //MySql은 IDENTITY, Oracle은 SEQUENCE, 자동은 Auto
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //컬럼 이름 명시. DB의 컬럼 이름과 다를 경우 명시를 통해 매핑 가능
    @Column(name = "name")
    private String name;
}
