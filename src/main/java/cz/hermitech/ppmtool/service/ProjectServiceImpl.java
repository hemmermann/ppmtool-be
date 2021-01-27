package cz.hermitech.ppmtool.service;

import cz.hermitech.ppmtool.domain.Project;
import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;
import cz.hermitech.ppmtool.error.NotFoundException;
import cz.hermitech.ppmtool.mapper.ProjectMapper;
import cz.hermitech.ppmtool.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

import static cz.hermitech.ppmtool.mapper.ProjectMapper.MAPPER;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public ProjectDto findProjectById(String id) {
        Project project = projectRepository.findById(id)
                                                 .orElseThrow(() -> new NotFoundException(
                                                         "Project not " +
                                                                 "found"));

        return MAPPER.toProjectDto(project);
    }

    @Override
    public ProjectDto updateProject(Project project) {
        return null;
    }

    @Override
    public ProjectDto createProject(ProjectCreateDto projectCreateDto) {
        Project project = MAPPER.toProject(projectCreateDto);
        Project savedProject = projectRepository.save(project);
        return MAPPER.toProjectDto(savedProject);
    }

    @Override
    public ProjectDto deleteProject(String id) {
        return null;
    }

    @Override
    public Set<ProjectDto> findAllProjects() {
        return null;
    }

    @Override
    public void deleteAllProjects() {

    }
}
