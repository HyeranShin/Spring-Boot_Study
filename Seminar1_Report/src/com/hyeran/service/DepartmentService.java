package com.hyeran.service;

import com.hyeran.model.Department;

public interface DepartmentService {
    //학과 이름으로 조회
    Department getByDeptName(final String deptName);
}
