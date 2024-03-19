package br.com.luis.courseplatform.controller;


import br.com.luis.courseplatform.dtos.course.CourseRequestDto;
import br.com.luis.courseplatform.dtos.course.CourseResponseDto;
import br.com.luis.courseplatform.services.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> findAllCourses() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> findCourseById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return new ResponseEntity<>(service.create(courseRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable("id") UUID id,
                                                          @RequestBody CourseRequestDto courseRequestDto) {
        return new ResponseEntity<>(service.update(id, courseRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
