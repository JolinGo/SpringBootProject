package com.rest.webservices.restfulwebservices.user;

import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private UserRepository repository;

    public UserJpaResource(UserRepository repository) {
        this.repository = repository;
    }

    // Get /users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    // Get /user/{id}
    @GetMapping("/jpa/user/{id}")
    public User retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
//        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id:" + id);
        }
        return user.get();
    }

    // Post /users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Delete /user/{id}
    @DeleteMapping("/jpa/user/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }
}
