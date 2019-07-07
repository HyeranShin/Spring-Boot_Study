package com.hyeran.seminar2.model;

public class User {
    private String name;
    private String part;

    public User(final String name, final String part) {
        this.name = name;
        this.part = part;
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
