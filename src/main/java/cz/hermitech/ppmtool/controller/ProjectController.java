package cz.hermitech.ppmtool.controller;

import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;
import cz.hermitech.ppmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ProjectDto findProject(@PathVariable("projectId") String id){
      return projectService.findProjectById(id);
    }

    @PostMapping
    public ProjectDto createProject(@RequestBody @Valid ProjectCreateDto projectCreateDto){
        return projectService.createProject(projectCreateDto);
    }
}
