package com.udemy.hibernateJpa.services.impls;

import com.udemy.hibernateJpa.DTOs.TeacherCreateDTO;
import com.udemy.hibernateJpa.DTOs.TeacherPatchDTO;
import com.udemy.hibernateJpa.DTOs.TeacherResponseDTO;
import com.udemy.hibernateJpa.DTOs.TeacherUpdateDTO;
import com.udemy.hibernateJpa.entities.Teacher;
import com.udemy.hibernateJpa.mappers.TeacherMapper;
import com.udemy.hibernateJpa.repositories.TeacherRepository;
import com.udemy.hibernateJpa.services.interfaces.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherResponseDTO getOne(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .filter(t -> !t.getDeleted())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return teacherMapper.toResponseDTO(teacher);
    }

    @Override
    public List<TeacherResponseDTO> getAll() {
        return teacherRepository.findByDeletedFalse()
                .stream()
                .filter(t -> !t.getDeleted())
                .map(teacherMapper::toResponseDTO)
                .toList();
    }

    @Override
    public TeacherResponseDTO create(TeacherCreateDTO dto) {
        Teacher teacher = teacherMapper.fromCreateDTO(dto);
        teacher.setDeleted(false);

        Teacher saved = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(saved);
    }

    @Override
    public TeacherResponseDTO update(TeacherUpdateDTO dto) {
        Teacher teacher = teacherRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacherMapper.updateEntityFromUpdateDTO(dto, teacher);
        Teacher updated = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(updated);
    }

    @Override
    public TeacherResponseDTO patch(TeacherPatchDTO dto) {
        Teacher teacher = teacherRepository.findById(dto
                        .getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacherMapper.patchEntityFromPatchDTO(dto, teacher);
        Teacher patched = teacherRepository.save(teacher);
        return teacherMapper.toResponseDTO(patched);
    }

    @Override
    public void softDelete(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacher.setDeleted(true);
        teacherRepository.save(teacher);
    }
}
