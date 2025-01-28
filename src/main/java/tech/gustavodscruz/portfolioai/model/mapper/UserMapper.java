package tech.gustavodscruz.portfolioai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import tech.gustavodscruz.portfolioai.model.dto.UserDTO;
import tech.gustavodscruz.portfolioai.model.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, typeConversionPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    
    @Mapping(source = "linkedinProfile", target = "linkedin")
    @Mapping(source = "githubProfile", target = "github")
    UserDTO map(User user);

    @Mapping(source = "linkedin", target = "linkedinProfile")
    @Mapping(source = "github", target = "githubProfile")
    User map(UserDTO userDTO);
}
