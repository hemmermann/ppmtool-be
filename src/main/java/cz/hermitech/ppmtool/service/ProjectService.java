package cz.hermitech.ppmtool.service;

import cz.hermitech.ppmtool.domain.Project;
import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;

import java.util.Set;

public interface ProjectService {
    ProjectDto findProjectById(String id);
    ProjectDto updateProject(Project project);
    ProjectDto createProject(ProjectCreateDto project);
    void deleteProject(String id);
    Set<ProjectDto> findAllProjects();
    void deleteAllProjects();
    ProjectDto findProjectByIdentifier(String projectIdentifier);
}
