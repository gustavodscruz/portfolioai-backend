package tech.gustavodscruz.portfolioai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.gustavodscruz.portfolioai.model.entity.Profile;
import tech.gustavodscruz.portfolioai.model.entity.User;

import java.util.List;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByUser(User user);
}
