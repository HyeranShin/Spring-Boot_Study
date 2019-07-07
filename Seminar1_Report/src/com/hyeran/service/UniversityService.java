package com.hyeran.service;

import com.hyeran.model.University;

public interface UniversityService {
    //대학 이름으로 조회
    University getByUnivName(final String univName);
}
