package br.com.luis.courseplatform.services;


import br.com.luis.courseplatform.dtos.course.CourseRequestDto;
import br.com.luis.courseplatform.dtos.course.CourseResponseDto;
import br.com.luis.courseplatform.models.Course;
import br.com.luis.courseplatform.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {


    private final CourseRepository repository;

    public List<CourseResponseDto> findAll() {

        return repository.findAll()
                .stream()
                .map(course -> new CourseResponseDto(
                        course.getId(),
                        course.getTitle(),
                        course.getDescription(),
                        course.getPrice(),
                        course.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    private CourseResponseDto courseResponseDto(Course course) {

        return new CourseResponseDto(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getPrice(),
                course.getCreatedAt()
        );
    }

    public CourseResponseDto findById(UUID id) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não foi encontrado"));

        return courseResponseDto(course);
    }

    public CourseResponseDto create(CourseRequestDto courseRequestDto) {

        Course course = new Course(courseRequestDto);

        Course savedCourse = repository.save(course);

        return courseResponseDto(savedCourse);
    }

    public CourseResponseDto update(UUID id, CourseRequestDto courseRequestDto) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não foi encontrado"));

        course.setTitle(courseRequestDto.title());
        course.setDescription(courseRequestDto.description());
        course.setPrice(courseRequestDto.price());

        Course updatedCourse = repository.save(course);

        return courseResponseDto(updatedCourse);

    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
