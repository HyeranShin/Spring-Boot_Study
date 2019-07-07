package com.hyeran.model;

//toString
//Constructor
//getter
//setter
public class University {
    //대학 고유 번호
    private Long univ_idx;

    //대학 이름
    private String univ_name;

    //대학 전화번호
    private String univ_phone;

    //대학 주소
    private String univ_address;

    public University(final Long univ_idx, final String univ_name, final String univ_phone, final String univ_address) {
        this.univ_idx = univ_idx;
        this.univ_name = univ_name;
        this.univ_phone = univ_phone;
        this.univ_address = univ_address;
    }

    public Long getUniv_idx() {
        return univ_idx;
    }

    public void setUniv_idx(final Long univ_idx) {
        this.univ_idx = univ_idx;
    }

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(final String univ_name) {
        this.univ_name = univ_name;
    }

    public String getUniv_phone() {
        return univ_phone;
    }

    public void setUniv_phone(final String univ_phone) {
        this.univ_phone = univ_phone;
    }

    public String getUniv_Address() {
        return univ_address;
    }

    public void setUniv_Address(final String univ_address) {
        this.univ_address = univ_address;
    }

    @Override
    public String toString() {
        return "University{" +
                "univ_idx=" + univ_idx +
                ", name='" + univ_name + '\'' +
                ", phone='" + univ_phone + '\'' +
                ", address='" + univ_address + '\'' +
                '}';
    }
}
