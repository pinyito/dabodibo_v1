package com.dabodibo.capitalhub.service.impl;

import com.dabodibo.capitalhub.dto.ProjectDto;
import com.dabodibo.capitalhub.entity.Project;
import com.dabodibo.capitalhub.mapper.ProjectMapper;
import com.dabodibo.capitalhub.repository.ProjectRepository;
import com.dabodibo.capitalhub.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> findAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(ProjectMapper::mapToProjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createProject(ProjectDto projectDto) {
        Project project = ProjectMapper.mapToProjectEntity(projectDto);
        projectRepository.save(project);
    }
}
