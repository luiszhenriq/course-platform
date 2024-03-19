package br.com.luis.courseplatform.repositories;

import br.com.luis.courseplatform.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
