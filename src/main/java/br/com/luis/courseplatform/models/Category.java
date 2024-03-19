package br.com.luis.courseplatform.models;


import br.com.luis.courseplatform.dtos.category.CategoryRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    public Category(CategoryRequestDto categoryRequestDto) {
        this.name = categoryRequestDto.name();
    }
}
