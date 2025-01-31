package tech.gustavodscruz.portfolioai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.gustavodscruz.portfolioai.model.entity.Project;
import tech.gustavodscruz.portfolioai.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> findAllByUserId(Long id) {
        return projectRepository.findByUserId(id);
    } 
}
