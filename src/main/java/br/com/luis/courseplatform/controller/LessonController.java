package br.com.luis.courseplatform.controller;


import br.com.luis.courseplatform.dtos.lesson.LessonRequestDto;
import br.com.luis.courseplatform.dtos.lesson.LessonResponseDto;
import br.com.luis.courseplatform.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService service;


    @GetMapping
    public ResponseEntity<List<LessonResponseDto>> findAllLessons() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponseDto> findLessonById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LessonResponseDto> createLesson(@RequestBody LessonRequestDto lessonRequestDto) {
        return new ResponseEntity<>(service.create(lessonRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponseDto> updateLesson(@PathVariable("id") UUID id,
                                                          @RequestBody LessonRequestDto lessonRequestDto) {
        return new ResponseEntity<>(service.update(id, lessonRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessonById(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
