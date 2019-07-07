package com.hyeran.service.impl;

import com.hyeran.model.University;
import com.hyeran.model.builder.UniversityBuilder;
import com.hyeran.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {

    @Override
    public University getByUnivName(String univName) {

        UniversityBuilder universityBuilder = new UniversityBuilder();
        University university = universityBuilder.build();
        return university;
    }
}
