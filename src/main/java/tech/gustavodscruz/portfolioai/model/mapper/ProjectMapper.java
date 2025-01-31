package tech.gustavodscruz.portfolioai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import tech.gustavodscruz.portfolioai.model.dto.ProjectDTO;
import tech.gustavodscruz.portfolioai.model.entity.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", expression = "java(projectDTO.userId())")
    Project map (ProjectDTO projectDTO);

    @Mapping(target = "userId", expression = "java(project.getUser().getId())")
    ProjectDTO map (Project project);

    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", expression = "java(projectDTO.userId())")
    void updateProjectFromDTO(ProjectDTO projectDTO, @MappingTarget Project project);
}
