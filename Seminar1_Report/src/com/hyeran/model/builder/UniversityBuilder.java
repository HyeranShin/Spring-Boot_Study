package com.hyeran.model.builder;

import com.hyeran.model.University;

public class UniversityBuilder {
    //대학 고유 번호
    private Long univ_idx;

    //대학 이름
    private String univ_name;

    //대학 전화번호
    private String univ_phone;

    //대학 주소
    private String univ_address;

    public UniversityBuilder setUniv_idx(final Long univ_idx) {
        this.univ_idx = univ_idx;
        return this;
    }

    public UniversityBuilder setUniv_name(final String univ_name) {
        this.univ_name = univ_name;
        return this;
    }

    public UniversityBuilder setUniv_phone(final String univ_phone) {
        this.univ_phone = univ_phone;
        return this;
    }

    public UniversityBuilder setUniv_address(final String univ_address) {
        this.univ_address = univ_address;
        return this;
    }

    public University build() {
        return new University(this.univ_idx, this.univ_name, this.univ_phone, this.univ_address);
    }
}
