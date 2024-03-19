package br.com.luis.courseplatform.dtos.assessment;

import java.util.UUID;

public record AssessmentResponseDto(UUID id,
                                    String comment,
                                    String createdAt) {
}
