package br.com.luis.courseplatform.dtos.lesson;

import java.util.UUID;

public record LessonResponseDto(UUID id,
                                String title,
                                String videoUrl,
                                Integer duration) {
}
