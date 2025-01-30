package tech.gustavodscruz.portfolioai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.gustavodscruz.portfolioai.model.dto.UserDTO;
import tech.gustavodscruz.portfolioai.model.entity.User;
import tech.gustavodscruz.portfolioai.model.mapper.UserMapper;
import tech.gustavodscruz.portfolioai.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = userMapper.map(userDTO);
        user = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        Optional<User> user = userService.findUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userService.updateUser(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        if (userService.deleteUser(id)) 
        return ResponseEntity.status(HttpStatus.valueOf(204)).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> alterUserPhoto(@PathVariable Long userId, @RequestBody User.PhotoUrlDTO photoUrl) {
        return ResponseEntity.ok().body(userService.alterPhoto(userId, photoUrl.photoUrl()));
    }

}
