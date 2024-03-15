package br.com.luis.courseplatform.dtos.user;

import br.com.luis.courseplatform.models.enums.UserType;


public record UserRequestDto(String name,
                             String email,
                             String password,
                             UserType userType) {
}
