package com.dabodibo.capitalhub.repository;

import com.dabodibo.capitalhub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // one query method
    Role findByName(String name);
}
