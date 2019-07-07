package com.hyeran.model;

//toString
//Constructor
//getter
//setter
public class Department extends University {
    //학과 고유 번호

    private Long dept_idx;
    //학과 이름

    private String dept_name;
    //학과 전화번호

    private String dept_phone;
    //학과 타입(공대, 자연대, 사범대, 치대..)

    private String dept_type;
    public Department(final Long univ_idx, final String univ_name, final String univ_phone, final String univ_address, final Long dept_idx, final String dept_name, final String dept_phone, final String dept_type) {
        super(univ_idx, univ_name, univ_phone, univ_address);
        this.dept_idx = dept_idx;
        this.dept_name = dept_name;
        this.dept_phone = dept_phone;
        this.dept_type = dept_type;
    }

    public Long getDept_idx() {
        return dept_idx;
    }

    public Department setDept_idx(final Long dept_idx) {
        this.dept_idx = dept_idx;
        return this;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(final String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_phone() {
        return dept_phone;
    }

    public void setDept_phone(final String dept_phone) {
        this.dept_phone = dept_phone;
    }

    public String getDept_type() {
        return dept_type;
    }

    public void setDept_type(final String dept_type) {
        this.dept_type = dept_type;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_idx=" + dept_idx +
                ", dept_name='" + dept_name + '\'' +
                ", dept_phone='" + dept_phone + '\'' +
                ", dept_type='" + dept_type + '\'' +
                '}';
    }
}
