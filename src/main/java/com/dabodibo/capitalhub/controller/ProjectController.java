package com.dabodibo.capitalhub.controller;

import com.dabodibo.capitalhub.dto.ProjectDto;
import com.dabodibo.capitalhub.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // handler method to handle GET request and returns model and view
    @GetMapping("/admin/projects")
    public String projects(Model model) {
        List<ProjectDto> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return "admin/projects";
    }

    // handler method to handle new project request
    @GetMapping("/admin/projects/new-project")
    public String newProject(Model model) {
        ProjectDto projectDto = new ProjectDto();
        model.addAttribute("project", projectDto);
        return "admin/create-project";
    }

    // handler method to handle new project creation request
    @PostMapping("/admin/projects")
    public String createNewProject(@ModelAttribute ProjectDto projectDto){
        projectDto.setUrl(getUrl(projectDto.getTitle()));
        projectService.createProject(projectDto);
        return "redirect:/admin/projects"; // Consider sorting projects by createdOn
    }

    // defines the project category image for aesthetic UI display
    private static String getUrl(String projectTitle) { //regex to form the image url based off project category
        // @{images/SpringIntroThumb.png}
        // will use url for now...and construct it from the title: titleword1-titleword2
        String title = projectTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-"); // replace any symbols with -
        return url;
    }

}
