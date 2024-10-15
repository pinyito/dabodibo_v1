package com.dabodibo.capitalhub.service;

import com.dabodibo.capitalhub.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAllProjects();
    void createProject(ProjectDto projectDto);
}
