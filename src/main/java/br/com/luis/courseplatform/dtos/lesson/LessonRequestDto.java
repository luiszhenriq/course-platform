package br.com.luis.courseplatform.dtos.lesson;

public record LessonRequestDto(
        String title,
        String videoUrl,
        Integer duration
) {
}
