package com.hyeran.model.builder;

import com.hyeran.model.Student;

public class StudentBuilder extends DepartmentBuilder {
    //학번
    private Long student_idx;

    //이름
    private String student_name;

    //학년
    private int student_grade;

    //학과
    private String student_dept;

    //이메일
    private String student_email;

    //주소
    private String student_address;

    //나이
    private int age;

    //현재 상태(휴학, 재학, 군휴학, 취업계)
    private String status;

    public StudentBuilder setStudent_idx(final Long student_idx) {
        this.student_idx = student_idx;
        return this;
    }

    public StudentBuilder setStudent_name(final String student_name) {
        this.student_name = student_name;
        return this;
    }

    public StudentBuilder setStudent_grade(final int student_grade) {
        this.student_grade = student_grade;
        return this;
    }

    public StudentBuilder setStudent_dept(final String student_dept) {
        this.student_dept = student_dept;
        return this;
    }

    public StudentBuilder setStudent_email(final String student_email) {
        this.student_email = student_email;
        return this;
    }

    public StudentBuilder setStudent_address(final String student_address) {
        this.student_address = student_address;
        return this;
    }

    public StudentBuilder setAge(final int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setStatus(final String status) {
        this.status = status;
        return this;
    }

    public Student build() {
        return new Student(super.build().getUniv_idx(), super.build().getUniv_name(), super.build().getUniv_phone(), super.build().getUniv_Address(), super.build().getDept_idx(), super.build().getDept_name(), super.build().getDept_phone(), super.build().getDept_type(), this.student_idx, this.student_name, this.student_grade, this.student_dept, this.student_email, this.student_address, this.age, this.status);
    }
}
