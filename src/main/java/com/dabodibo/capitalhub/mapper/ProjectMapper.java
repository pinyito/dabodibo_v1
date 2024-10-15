package com.dabodibo.capitalhub.mapper;

import com.dabodibo.capitalhub.dto.ProjectDto;
import com.dabodibo.capitalhub.entity.Project;

public class ProjectMapper {
    // convert Project entity to ProjectDto
    public static ProjectDto mapToProjectDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .url(project.getUrl())
                .content(project.getContent())
                .shortDescription(project.getShortDescription())
                .createdOn(project.getCreatedOn())
                .updatedOn(project.getUpdatedOn())
                .build();
    }

    // convert ProjectDto to Project entity
    public static Project mapToProjectEntity(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .title(projectDto.getTitle())
                .url(projectDto.getUrl())
                .content(projectDto.getContent())
                .shortDescription(projectDto.getShortDescription())
                .createdOn(projectDto.getCreatedOn())
                .updatedOn(projectDto.getUpdatedOn())
                .build();
    }
}
