package br.com.luis.courseplatform.dtos.user;

import br.com.luis.courseplatform.models.enums.UserType;

import java.util.UUID;

public record UserResponseDto(UUID id,
                              String name,
                              String email,
                              String password,
                              UserType userType) {
}
