package cz.hermitech.ppmtool.mapper;

import cz.hermitech.ppmtool.domain.Project;
import cz.hermitech.ppmtool.dto.ProjectCreateDto;
import cz.hermitech.ppmtool.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface ProjectMapper {
    ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "createdBy", ignore=true)
    @Mapping(target = "createdAt",ignore=true)
    @Mapping(target = "updatedAt", ignore=true)
    @Mapping(target = "updatedBy",ignore=true)
    Project toProject(ProjectCreateDto projectCreateDto);

    ProjectDto toProjectDto(Project project);
}
