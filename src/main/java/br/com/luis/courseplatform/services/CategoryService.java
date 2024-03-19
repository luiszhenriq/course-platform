package br.com.luis.courseplatform.services;

import br.com.luis.courseplatform.dtos.category.CategoryRequestDto;
import br.com.luis.courseplatform.dtos.category.CategoryResponseDto;
import br.com.luis.courseplatform.models.Category;
import br.com.luis.courseplatform.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryResponseDto> findAll() {

        return repository.findAll()
                .stream()
                .map(category -> new CategoryResponseDto(
                        category.getId(),
                        category.getName()
                ))
                .collect(Collectors.toList());
    }

    private CategoryResponseDto categoryResponseDto(Category category) {

        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }

    public CategoryResponseDto findById(UUID id) {

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        return categoryResponseDto(category);
    }

    public CategoryResponseDto create(CategoryRequestDto categoryRequestDto) {

        Category category = new Category(categoryRequestDto);

        Category savedCategory = repository.save(category);

        return categoryResponseDto(savedCategory);
    }

    public CategoryResponseDto update(UUID id, CategoryRequestDto categoryRequestDto) {

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

       category.setName(categoryRequestDto.name());

       Category updatedCategory = repository.save(category);

        return categoryResponseDto(updatedCategory);

    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
