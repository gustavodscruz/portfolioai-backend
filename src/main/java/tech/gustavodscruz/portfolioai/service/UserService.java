package tech.gustavodscruz.portfolioai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.gustavodscruz.portfolioai.model.dto.UserDTO;
import tech.gustavodscruz.portfolioai.model.entity.User;
import tech.gustavodscruz.portfolioai.model.mapper.UserMapper;
import tech.gustavodscruz.portfolioai.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User alterPhoto(Long id, String photoUrl){
        User user = userRepository.getReferenceById(id);
        user.setPhotoUrl(photoUrl);
        return userRepository.save(user);
    }
    public User updateUser(Long id, UserDTO userDTO){
        User user = userRepository.getReferenceById(id);
        userMapper.updateUserFromDTO(userDTO, user);
        return userRepository.save(user);
    }
    public boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }
    public User findById(Long id){
        return userRepository.getReferenceById(id);
    }
}
