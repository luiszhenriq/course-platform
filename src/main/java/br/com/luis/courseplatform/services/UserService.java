package br.com.luis.courseplatform.services;

import br.com.luis.courseplatform.dtos.user.UserRequestDto;
import br.com.luis.courseplatform.dtos.user.UserResponseDto;
import br.com.luis.courseplatform.dtos.user.UserUpdateDto;
import br.com.luis.courseplatform.models.User;
import br.com.luis.courseplatform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<UserResponseDto> findAll() {

        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getUserType()
                ))
                .collect(Collectors.toList());
    }

    public UserResponseDto create(UserRequestDto user) {

        User newUser = new User(user);

        User savedUser = repository.save(newUser);

        return userResponseDto(savedUser);
    }

    public UserResponseDto findById(UUID id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        return userResponseDto(user);
    }

    public UserResponseDto update(UUID id, UserUpdateDto userUpdateDto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        user.setName(userUpdateDto.name());
        user.setPassword(userUpdateDto.password());

        User updatedUser = repository.save(user);

        return userResponseDto(user);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private UserResponseDto userResponseDto(User user) {

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getUserType()
        );
    }
}
