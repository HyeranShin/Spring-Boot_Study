package com.hyeran.service.impl;

import com.hyeran.model.Professor;
import com.hyeran.model.builder.ProfessorBuilder;
import com.hyeran.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

    @Override
    public Professor getByProfIdx(int profIdx) {

        ProfessorBuilder professorBuilder = new ProfessorBuilder();
        Professor professor = professorBuilder.build();
        return professor;
    }
}
