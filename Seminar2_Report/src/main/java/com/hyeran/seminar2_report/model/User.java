package com.hyeran.seminar2_report.model;

public class User {
    //회원 고유번호
    private int user_idx;
    //회원 이름
    private String name;
    //회원 파트
    private String part;

    public User(final int user_idx, final String name, final String part) {
        this.user_idx = user_idx;
        this.name = name;
        this.part = part;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public User setUser_idx(final int user_idx) {
        this.user_idx = user_idx;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(final String name) {
        this.name = name;
        return this;
    }

    public String getPart() {
        return part;
    }

    public User setPart(final String part) {
        this.part = part;
        return this;
    }
}
