package tech.gustavodscruz.portfolioai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.gustavodscruz.portfolioai.model.dto.ProfileDTO;
import tech.gustavodscruz.portfolioai.model.entity.Profile;
import tech.gustavodscruz.portfolioai.model.entity.User;
import tech.gustavodscruz.portfolioai.model.mapper.ProfileMapper;
import tech.gustavodscruz.portfolioai.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileMapper profileMapper;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public boolean deleteProfile(Long id) {
        profileRepository.deleteById(id);
        return !profileRepository.existsById(id);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public List<Profile> getByUserId(Long userId) {
        return profileRepository.findByUserId(userId);
    }

    public Profile findById(Long id) {
        return profileRepository.getReferenceById(id);
    }

    public Profile updateProfile(Long id, ProfileDTO profileDTO) {
        Profile profile = profileRepository.getReferenceById(id);
        profileMapper.updateProfileFromDTO(profileDTO, profile);
        return profileRepository.save(profile);
    }
}
