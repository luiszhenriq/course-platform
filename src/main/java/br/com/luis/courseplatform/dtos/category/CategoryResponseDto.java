package br.com.luis.courseplatform.dtos.category;

import java.util.UUID;

public record CategoryResponseDto(UUID id,
                                  String name) {
}
