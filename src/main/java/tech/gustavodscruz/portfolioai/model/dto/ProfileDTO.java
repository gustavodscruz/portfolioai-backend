package tech.gustavodscruz.portfolioai.model.dto;

import java.util.List;

public record ProfileDTO(
    Long userId,
    String headline, 
    String about,
    List<String> experiences,
    List<String> skills,
    List<String> education
) {}
