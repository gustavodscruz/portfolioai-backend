package tech.gustavodscruz.portfolioai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.gustavodscruz.portfolioai.model.entity.Project;
import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);
}
