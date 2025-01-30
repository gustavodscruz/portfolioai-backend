package tech.gustavodscruz.portfolioai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.gustavodscruz.portfolioai.model.dto.ProfileDTO;
import tech.gustavodscruz.portfolioai.model.entity.Profile;
import tech.gustavodscruz.portfolioai.model.mapper.ProfileMapper;
import tech.gustavodscruz.portfolioai.service.ProfileService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @Autowired
    ProfileMapper profileMapper;
    
    @GetMapping
    public ResponseEntity<List<Profile>> findAllProfiles() {
        return ResponseEntity.ok().body(profileService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findById(@RequestParam Long id) {
        return ResponseEntity.ok().body(profileService.findById(id));
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Profile>> findByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok().body(profileService.getByUserId(userId));
    }
    
    @PostMapping()
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDTO profileDTO) {
        var profile = profileMapper.map(profileDTO);
        return ResponseEntity.ok().body(profileService.createProfile(profile));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        var profile = profileService.findById(id);
        profileMapper.updateProfileFromDTO(profileDTO, profile);    
        return ResponseEntity.ok().body(profileService.updateProfile(id, profileDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id){
        if (profileService.deleteProfile(id)) return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
        return ResponseEntity.notFound().build();
    }
    
}
