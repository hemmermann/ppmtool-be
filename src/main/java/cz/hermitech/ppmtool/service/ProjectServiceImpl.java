package cz.hermitech.ppmtool.service;

import cz.hermitech.ppmtool.domain.Project;
import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;
import cz.hermitech.ppmtool.error.ConstraintDbException;
import cz.hermitech.ppmtool.error.NotFoundException;
import cz.hermitech.ppmtool.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        try {
            Project savedProject = projectRepository.save(project);
            return MAPPER.toProjectDto(savedProject);
        } catch (Exception ex) {
            throw new ConstraintDbException(ex.getMessage());
        }
    }

    @Override
    public void deleteProject(String id) {
       try {
           projectRepository.deleteById(id);
       }catch (Exception ex){
           throw new ConstraintDbException(ex.getMessage());
       }
    }

    @Override
    public Set<ProjectDto> findAllProjects() {
        Set<Project> projects =
                new HashSet<>(projectRepository.findAll());
        return projects.stream().map(MAPPER::toProjectDto).collect(Collectors.toSet());
    }

    @Override
    public void deleteAllProjects() {

    }

    @Override
    public ProjectDto findProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier)
                                           .orElseThrow(() -> new NotFoundException(
                                                   "Project with identifier: " +
                                                           projectIdentifier + " not found"));
        return MAPPER.toProjectDto(project);
    }
}
