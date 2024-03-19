package br.com.luis.courseplatform.services;


import br.com.luis.courseplatform.dtos.lesson.LessonRequestDto;
import br.com.luis.courseplatform.dtos.lesson.LessonResponseDto;
import br.com.luis.courseplatform.models.Lesson;
import br.com.luis.courseplatform.repositories.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository repository;

    public List<LessonResponseDto> findAll() {

        return repository.findAll()
                .stream()
                .map(lesson -> new LessonResponseDto(
                        lesson.getId(),
                        lesson.getTitle(),
                        lesson.getVideoUrl(),
                        lesson.getDuration()
                ))
                .collect(Collectors.toList());
    }

    private LessonResponseDto lessonResponseDto(Lesson lesson) {

        return new LessonResponseDto(
                lesson.getId(),
                lesson.getTitle(),
                lesson.getVideoUrl(),
                lesson.getDuration()
        );
    }

    public LessonResponseDto findById(UUID id) {

        Lesson lesson = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não foi encontrado"));

        return lessonResponseDto(lesson);
    }

    public LessonResponseDto create(LessonRequestDto lessonRequestDto) {

        Lesson lesson = new Lesson(lessonRequestDto);

        Lesson savedLesson = repository.save(lesson);

        return lessonResponseDto(savedLesson);
    }

    public LessonResponseDto update(UUID id, LessonRequestDto lessonRequestDto) {

        Lesson lesson = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não foi encontrado"));

        lesson.setTitle(lessonRequestDto.title());
        lesson.setVideoUrl(lessonRequestDto.videoUrl());
        lesson.setDuration(lessonRequestDto.duration());

        Lesson updatedLesson = repository.save(lesson);

        return lessonResponseDto(updatedLesson);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
