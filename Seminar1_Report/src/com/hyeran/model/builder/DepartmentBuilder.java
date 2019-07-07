package com.hyeran.model.builder;

import com.hyeran.model.Department;

public class DepartmentBuilder extends UniversityBuilder {
    //학과 고유 번호
    private Long dept_idx;

    //학과 이름
    private String dept_name;

    //학과 전화번호
    private String dept_phone;

    //학과 타입(공대, 자연대, 사범대, 치대..)
    private String dept_type;

    public DepartmentBuilder setDept_idx(final Long dept_idx) {
        this.dept_idx = dept_idx;
        return this;
    }

    public DepartmentBuilder setDept_name(final String dept_name) {
        this.dept_name = dept_name;
        return this;
    }

    public DepartmentBuilder setDept_phone(final String dept_phone) {
        this.dept_phone = dept_phone;
        return this;
    }

    public DepartmentBuilder setDept_type(final String dept_type) {
        this.dept_type = dept_type;
        return this;
    }

    public Department build() {
        return new Department(super.build().getUniv_idx(), super.build().getUniv_name(), super.build().getUniv_phone(), super.build().getUniv_Address(), this.dept_idx, this.dept_name, this.dept_phone, this.dept_type);
    }
}
