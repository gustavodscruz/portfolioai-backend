package tech.gustavodscruz.portfolioai.model.dto;

import java.util.List;

public record ProjectDTO(
    Long userId,
    String name,
    String description,
    String repoUrl,
    String liveDemoUrl,
    List<String> technologies
) {}
