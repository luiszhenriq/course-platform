package br.com.luis.courseplatform.repositories;

import br.com.luis.courseplatform.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
}
