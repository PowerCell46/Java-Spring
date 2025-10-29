package com.udemy.hibernateJpa.controllers;


import com.udemy.hibernateJpa.DTOs.TeacherCreateDTO;
import com.udemy.hibernateJpa.DTOs.TeacherPatchDTO;
import com.udemy.hibernateJpa.DTOs.TeacherResponseDTO;
import com.udemy.hibernateJpa.DTOs.TeacherUpdateDTO;
import com.udemy.hibernateJpa.services.interfaces.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacher(@PathVariable Integer id) {
        TeacherResponseDTO teacher = teacherService.getOne(id);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> getAllTeachers() {
        List<TeacherResponseDTO> teachers = teacherService.getAll();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> createTeacher(@Valid @RequestBody TeacherCreateDTO dto) {
        TeacherResponseDTO createdTeacher = teacherService.create(dto);
        return ResponseEntity.ok(createdTeacher);
    }

    @PutMapping
    public ResponseEntity<TeacherResponseDTO> updateTeacher(@Valid @RequestBody TeacherUpdateDTO dto) {
        TeacherResponseDTO updatedTeacher = teacherService.update(dto);
        return ResponseEntity.ok(updatedTeacher);
    }

    @PatchMapping
    public ResponseEntity<TeacherResponseDTO> patchTeacher(@RequestBody TeacherPatchDTO dto) {
        TeacherResponseDTO patchedTeacher = teacherService.patch(dto);
        return ResponseEntity.ok(patchedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Integer id) {
        teacherService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
