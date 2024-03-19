package br.com.luis.courseplatform.dtos.course;

import java.time.LocalDate;

public record CourseRequestDto(
        String title,
        String description,
        Integer price
) {
}
