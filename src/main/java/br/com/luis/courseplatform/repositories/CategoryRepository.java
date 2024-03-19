package br.com.luis.courseplatform.repositories;

import br.com.luis.courseplatform.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
