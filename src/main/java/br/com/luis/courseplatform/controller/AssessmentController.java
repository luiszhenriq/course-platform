package br.com.luis.courseplatform.controller;


import br.com.luis.courseplatform.dtos.assessment.AssessmentRequestDto;
import br.com.luis.courseplatform.dtos.assessment.AssessmentResponseDto;
import br.com.luis.courseplatform.services.AssessmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/assessment")
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService service;


    @GetMapping
    public ResponseEntity<List<AssessmentResponseDto>> findAllAssessments() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentResponseDto> findAssessmentById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AssessmentResponseDto> createAssessment(@RequestBody AssessmentRequestDto assessmentRequestDto) {
        return new ResponseEntity<>(service.create(assessmentRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AssessmentResponseDto> updateAssessment(@PathVariable("id") UUID id,
                                                              @RequestBody AssessmentRequestDto assessmentRequestDto) {
        return new ResponseEntity<>(service.update(id, assessmentRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessmentById(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
