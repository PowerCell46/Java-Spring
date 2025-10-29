package com.udemy.hibernateJpa.services.interfaces;

import com.udemy.hibernateJpa.DTOs.TeacherCreateDTO;
import com.udemy.hibernateJpa.DTOs.TeacherPatchDTO;
import com.udemy.hibernateJpa.DTOs.TeacherResponseDTO;
import com.udemy.hibernateJpa.DTOs.TeacherUpdateDTO;

import java.util.List;


public interface TeacherService {

    TeacherResponseDTO getOne(Integer id);

    List<TeacherResponseDTO> getAll();

    TeacherResponseDTO create(TeacherCreateDTO dto);

    TeacherResponseDTO update(TeacherUpdateDTO dto);

    TeacherResponseDTO patch(TeacherPatchDTO dto);

    void softDelete(Integer id);
}
