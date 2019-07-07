package com.hyeran.service.impl;

import com.hyeran.model.Department;
import com.hyeran.model.builder.DepartmentBuilder;
import com.hyeran.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department getByDeptName(String deptName) {

        DepartmentBuilder departmentBuilder = new DepartmentBuilder();
        Department department = departmentBuilder.build();
        return department;
    }
}
