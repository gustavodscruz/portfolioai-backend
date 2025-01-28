package tech.gustavodscruz.portfolioai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.gustavodscruz.portfolioai.model.entity.User;
import tech.gustavodscruz.portfolioai.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User alterOrAddPhoto(Long id, String photoUrl){
        User user = userRepository.getReferenceById(id);
        user.setPhotoUrl(photoUrl);
        return userRepository.save(user);
    }
}
