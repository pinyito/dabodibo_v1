package com.dabodibo.capitalhub.repository;

import com.dabodibo.capitalhub.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // one query method defined
    Optional<Project> findByUrl(String url);
}
