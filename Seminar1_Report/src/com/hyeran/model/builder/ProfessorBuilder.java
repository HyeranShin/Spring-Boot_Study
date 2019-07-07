package com.hyeran.model.builder;

import com.hyeran.model.Professor;

public class ProfessorBuilder extends DepartmentBuilder {
    //교수 고유 번호
    private Long prof_idx;

    //교수 이름
    private String prof_name;

    //교수 학과
    private String prof_dept;

    //교수 전화번호
    private String prof_phone;

    //담당 과목
    private String prof_sub;

    public ProfessorBuilder setProf_idx(final Long prof_idx) {
        this.prof_idx = prof_idx;
        return this;
    }

    public ProfessorBuilder setProf_name(final String prof_name) {
        this.prof_name = prof_name;
        return this;
    }

    public ProfessorBuilder setProf_dept(final String prof_dept) {
        this.prof_dept = prof_dept;
        return this;
    }

    public ProfessorBuilder setProf_phone(final String prof_phone) {
        this.prof_phone = prof_phone;
        return this;
    }

    public ProfessorBuilder setProf_sub(final String prof_sub) {
        this.prof_sub = prof_sub;
        return this;
    }

    public Professor build() {
        return new Professor(super.build().getUniv_idx(), super.build().getUniv_name(), super.build().getUniv_phone(), super.build().getUniv_Address(), super.build().getDept_idx(), super.build().getDept_name(), super.build().getDept_phone(), super.build().getDept_type(), this.prof_idx, this.prof_name, this.prof_dept, this.prof_phone, this.prof_sub);
    }
}
