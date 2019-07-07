package com.hyeran.service.impl;

import com.hyeran.model.Student;
import com.hyeran.model.builder.StudentBuilder;
import com.hyeran.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student getByStudentIdx(int studentIdx) {

        //Builder로 객체 생성해서 반환
        StudentBuilder studentBuilder = new StudentBuilder();
        Student student = studentBuilder.build();
        return student;
    }
}
