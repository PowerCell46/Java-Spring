package com.udemy.hibernateJpa.mappers;

import com.udemy.hibernateJpa.DTOs.TeacherCreateDTO;
import com.udemy.hibernateJpa.DTOs.TeacherPatchDTO;
import com.udemy.hibernateJpa.DTOs.TeacherResponseDTO;
import com.udemy.hibernateJpa.DTOs.TeacherUpdateDTO;
import com.udemy.hibernateJpa.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherResponseDTO toResponseDTO(Teacher entity);

    Teacher fromCreateDTO(TeacherCreateDTO dto);

    void updateEntityFromUpdateDTO(TeacherUpdateDTO dto, @MappingTarget Teacher entity);

    void patchEntityFromPatchDTO(TeacherPatchDTO dto, @MappingTarget Teacher entity);
}
