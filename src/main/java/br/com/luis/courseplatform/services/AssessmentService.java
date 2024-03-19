package br.com.luis.courseplatform.services;

import br.com.luis.courseplatform.dtos.assessment.AssessmentRequestDto;
import br.com.luis.courseplatform.dtos.assessment.AssessmentResponseDto;
import br.com.luis.courseplatform.models.Assessment;
import br.com.luis.courseplatform.repositories.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssessmentService {

    private final AssessmentRepository repository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public List<AssessmentResponseDto> findAll() {

        return repository.findAll()
                .stream()
                .map(assessment -> new AssessmentResponseDto(
                        assessment.getId(),
                        assessment.getComment(),
                        assessment.getCreatedAt().format(formatter)
                ))
                .collect(Collectors.toList());
    }


    public AssessmentResponseDto findById(UUID id) {

        Assessment assessment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não foi encontrado"));

        return assessmentResponseDto(assessment);
    }

    public AssessmentResponseDto create(AssessmentRequestDto assessmentRequestDto) {

        Assessment assessment = new Assessment(assessmentRequestDto);

        Assessment savedAssessment = repository.save(assessment);

        return assessmentResponseDto(savedAssessment);
    }

    public AssessmentResponseDto update(UUID id, AssessmentRequestDto assessmentRequestDto) {

        Assessment assessment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não foi encontrado"));

        assessment.setComment(assessmentRequestDto.comment());

        Assessment updatedAssessment = repository.save(assessment);

        return assessmentResponseDto(updatedAssessment);

    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private AssessmentResponseDto assessmentResponseDto(Assessment assessment) {

        return new AssessmentResponseDto(
                assessment.getId(),
                assessment.getComment(),
                assessment.getCreatedAt().format(formatter)
        );
    }
}
