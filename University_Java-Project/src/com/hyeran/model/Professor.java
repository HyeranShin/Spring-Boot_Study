package com.hyeran.model;

//toString
//Constructor
//getter
//setter
public class Professor extends Department {
    //교수 고유 번호
    private Long prof_idx;

    //교수 이름
    private String prof_name;

    //교수 학과
    private String prof_dept;

    //교수 전화번호
    private String prof_phone;

    //담당 과목
    private String prof_subject;

    public Professor(final Long univ_idx, final String univ_name, final String univ_phone, final String univ_address, final Long dept_idx, final String dept_name, final String dept_phone, final String dept_type, final Long prof_idx, final String prof_name, final String prof_dept, final String prof_phone, final String prof_subject) {
        super(univ_idx, univ_name, univ_phone, univ_address, dept_idx, dept_name, dept_phone, dept_type);
        this.prof_idx = prof_idx;
        this.prof_name = prof_name;
        this.prof_dept = prof_dept;
        this.prof_phone = prof_phone;
        this.prof_subject = prof_subject;
    }

    public Long getProf_idx() {
        return prof_idx;
    }

    public void setProf_idx(Long prof_idx) {
        this.prof_idx = prof_idx;
    }

    public String getProf_name() {
        return prof_name;
    }

    public void setProf_name(String prof_name) {
        this.prof_name = prof_name;
    }

    public String getDept() {
        return prof_dept;
    }

    public void setDept(String dept) {
        this.prof_dept = dept;
    }

    public String getPhone() {
        return prof_phone;
    }

    public void setPhone(String phone) {
        this.prof_phone = phone;
    }

    public String getSubject() {
        return prof_subject;
    }

    public void setSubject(String subject) {
        this.prof_subject = subject;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "prof_idx=" + prof_idx +
                ", prof_name='" + prof_name + '\'' +
                ", dept='" + prof_dept + '\'' +
                ", phone='" + prof_phone + '\'' +
                ", subject='" + prof_subject + '\'' +
                '}';
    }
}
