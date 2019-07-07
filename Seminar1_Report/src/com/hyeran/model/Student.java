package com.hyeran.model;

//toString
//Constructor
//getter
//setter
public class Student extends Department {
    //학번
    private Long idx;

    //이름
    private String name;

    //학년
    private int grade;

    //학과
    private String dept;

    //이메일
    private String email;

    //주소
    private String address;

    //나이
    private int age;

    //현재 상태(휴학, 재학, 군휴학, 취업계)
    private String status;

    public Student(final Long univ_idx, final String univ_name, final String univ_phone, final String univ_address, final Long dept_idx, final String dept_name, final String dept_phone, final String dept_type, Long idx, String name, int grade, String dept, String email, String address, int age, String status) {
        super(univ_idx, univ_name, univ_phone, univ_address, dept_idx, dept_name, dept_phone, dept_type);
        this.idx = idx;
        this.name = name;
        this.grade = grade;
        this.dept = dept;
        this.email = email;
        this.address = address;
        this.age = age;
        this.status = status;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}
