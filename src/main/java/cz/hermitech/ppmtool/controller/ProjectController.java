package cz.hermitech.ppmtool.controller;

import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;
import cz.hermitech.ppmtool.service.ProjectService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ProjectDto findProject(@PathVariable("projectId") String id) {
        return projectService.findProjectById(id);
    }

    @GetMapping("/identifier/{projectIdentifier}")
    public ProjectDto findProjectByIdentifier(
            @PathVariable("projectIdentifier") String projectIdentifier) {
        return projectService.findProjectByIdentifier(projectIdentifier);
    }

    @PostMapping
    public ProjectDto createProject(@Valid @RequestBody ProjectCreateDto projectCreateDto) {
        return projectService.createProject(projectCreateDto);
    }

    @GetMapping
    public Set<ProjectDto> findAllProjects(){
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable String projectId){
        projectService.deleteProject(projectId);
    }
}
