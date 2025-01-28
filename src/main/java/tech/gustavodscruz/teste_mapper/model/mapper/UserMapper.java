package tech.gustavodscruz.teste_mapper.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.gustavodscruz.teste_mapper.model.dto.UserDTO;
import tech.gustavodscruz.teste_mapper.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(source = "linkedinProfile", target = "linkedin")
    @Mapping(source = "githubProfile", target = "github")
    UserDTO map(User user);
    @Mapping(source = "linkedin", target = "linkedinProfile")
    @Mapping(source = "github", target = "githubProfile")
    User map(UserDTO userDTO);
}
