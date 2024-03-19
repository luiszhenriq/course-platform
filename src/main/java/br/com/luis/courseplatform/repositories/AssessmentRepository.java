package br.com.luis.courseplatform.repositories;

import br.com.luis.courseplatform.models.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssessmentRepository extends JpaRepository<Assessment, UUID> {
}
