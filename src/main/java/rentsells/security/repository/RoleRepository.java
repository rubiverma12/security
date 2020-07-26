package rentsells.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import rentsells.security.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(String name);
}
