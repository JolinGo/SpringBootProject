package com.rest.webservices.restfulwebservices.user;

import org.springframework.data.web.JsonPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService userDaoService) {
        this.service = userDaoService;
    }

    // Get /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // Get /user/{id}
    @GetMapping("/user/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

    // Post /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Delete /user/{id}
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
