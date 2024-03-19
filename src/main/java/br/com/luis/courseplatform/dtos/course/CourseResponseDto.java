package br.com.luis.courseplatform.dtos.course;

import java.time.LocalDate;
import java.util.UUID;

public record CourseResponseDto(UUID id,
                                String title,
                                String description,
                                Integer price,
                                LocalDate createdAt) {
}
