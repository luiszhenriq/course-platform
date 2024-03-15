package br.com.luis.courseplatform.services;


import br.com.luis.courseplatform.dtos.module.ModuleRequestDto;
import br.com.luis.courseplatform.dtos.module.ModuleResponseDto;
import br.com.luis.courseplatform.models.Module;
import br.com.luis.courseplatform.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository repository;

    public List<ModuleResponseDto> findAll() {

        return repository.findAll()
                .stream()
                .map(module -> new ModuleResponseDto(
                        module.getId(),
                        module.getTitle()
                ))
                .collect(Collectors.toList());
    }

    public ModuleResponseDto findById(UUID id) {

        Module module = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        return moduleResponseDto(module);
    }


    public ModuleResponseDto create(ModuleRequestDto moduleRequestDto) {

        Module module = new Module(moduleRequestDto);

        Module savedModule = repository.save(module);

        return moduleResponseDto(savedModule);
    }

    public ModuleResponseDto update(UUID id, ModuleRequestDto moduleRequestDto) {

        Module module = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        module.setTitle(moduleRequestDto.title());

        Module updatedModule = repository.save(module);

        return moduleResponseDto(updatedModule);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private ModuleResponseDto moduleResponseDto(Module module) {

        return new ModuleResponseDto(
                module.getId(),
                module.getTitle()
        );
    }
}
