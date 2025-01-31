package tech.gustavodscruz.portfolioai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.gustavodscruz.portfolioai.model.dto.ProjectDTO;
import tech.gustavodscruz.portfolioai.model.entity.Project;
import tech.gustavodscruz.portfolioai.model.mapper.ProjectMapper;
import tech.gustavodscruz.portfolioai.repository.ProjectRepository;

@Service
public class ProjectService{
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectMapper projectMapper;

    
    public List<Project> findAllByUserId(Long id) {
        return projectRepository.findByUserId(id);
    }

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long id ){
        return projectRepository.findById(id);
    }

    public Project updateProject (ProjectDTO projectDTO, Long id){
        var project = projectRepository.getReferenceById(id); 
        projectMapper.updateProjectFromDTO(projectDTO, project);
        return projectRepository.save(project);
    }

    public boolean deleteProject (Long id) {
        if (projectRepository.existsById(id)){
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
