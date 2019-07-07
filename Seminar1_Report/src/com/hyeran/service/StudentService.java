package com.hyeran.service;

import com.hyeran.model.Student;

public interface StudentService {
    //학번으로 학생 조회
    Student getByStudentIdx(final int studentIdx);
}
