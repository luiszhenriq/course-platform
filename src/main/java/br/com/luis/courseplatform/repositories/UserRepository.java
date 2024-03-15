package br.com.luis.courseplatform.repositories;

import br.com.luis.courseplatform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
