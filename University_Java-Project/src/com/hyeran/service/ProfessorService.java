package com.hyeran.service;

import com.hyeran.model.Professor;

public interface ProfessorService {
    //교수 고유 번호로 조회
    Professor getByProfIdx(final int profIdx);
}
