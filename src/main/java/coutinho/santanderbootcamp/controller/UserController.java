package coutinho.santanderbootcamp.controller;

import coutinho.santanderbootcamp.domain.model.User;
import coutinho.santanderbootcamp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //TODO: changes for Autowired?
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //TODO: create UserDTO to return only necessary data
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(name = "id") Long id) {
        User userDb = userService.findById(id);
        return ResponseEntity.ok(userDb);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);

    }


}
