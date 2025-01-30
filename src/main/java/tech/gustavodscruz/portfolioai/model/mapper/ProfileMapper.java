package tech.gustavodscruz.portfolioai.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import tech.gustavodscruz.portfolioai.model.dto.ProfileDTO;
import tech.gustavodscruz.portfolioai.model.entity.Profile;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, typeConversionPolicy = ReportingPolicy.ERROR)
public interface ProfileMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", expression = "java(profileDTO.userId())")
    Profile map(ProfileDTO profileDTO);

    @Mapping(target = "userId", expression = "java(profile.getUser().getId())")
    ProfileDTO map(Profile profile);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", expression = "java(profileDTO.userId())")
    void updateProfileFromDTO(ProfileDTO profileDTO, @MappingTarget Profile profile);
}
