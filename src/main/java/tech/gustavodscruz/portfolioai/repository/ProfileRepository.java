package tech.gustavodscruz.portfolioai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.gustavodscruz.portfolioai.model.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {}
