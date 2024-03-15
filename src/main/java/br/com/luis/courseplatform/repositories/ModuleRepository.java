package br.com.luis.courseplatform.repositories;

import br.com.luis.courseplatform.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {
}
