package cz.hermitech.ppmtool.mapper;

import cz.hermitech.ppmtool.domain.Project;
import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface ProjectMapper {
    ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    Project toProject(ProjectCreateDto projectCreateDto);

    ProjectDto toProjectDto(Project project);
}
