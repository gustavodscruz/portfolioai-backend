package tech.gustavodscruz.portfolioai.model.dto;

import java.time.LocalDate;

public record ExperienceDTO(
    String jobRole, 
    String company, 
    LocalDate start, 
    LocalDate end,
    Long profileId
) {
    
}
