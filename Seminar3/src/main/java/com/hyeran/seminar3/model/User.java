package com.hyeran.seminar3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
public class User {
    private int userIdx;
    private String name;
    private String email;
}
