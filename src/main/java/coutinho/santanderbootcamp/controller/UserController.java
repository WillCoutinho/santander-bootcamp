package coutinho.santanderbootcamp.controller;

import coutinho.santanderbootcamp.domain.model.User;
import coutinho.santanderbootcamp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Users for bank dashboard")
public class UserController {

    @Autowired
    private UserService userService;

    //TODO: create UserDTO to return only necessary data
    @GetMapping("/{id}")
    @Operation(description = "Get an user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    public ResponseEntity<User> findById(@PathVariable(name = "id")
                                         @Parameter(name = "id",
                                                 description = "User ID",
                                                 example = "1") Long id) {
        User userDb = userService.findById(id);
        return ResponseEntity.ok(userDb);
    }

    @PostMapping
    @Operation(description = "Create an User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "422", description = "Business Exception. Please check the payload", content = @Content),
            @ApiResponse(responseCode = "404", description = "Feature/News code not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error not handled", content = @Content)
    })
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);
    }

//    @PutMapping("/{id}")
//    @Operation(description = "Update an User by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "User updated successfully"),
//            @ApiResponse(responseCode = "404", description = "User ID not found", content = @Content),
//            @ApiResponse(responseCode = "422", description = "Business Exception. Please check the payload", content = @Content),
//            @ApiResponse(responseCode = "500", description = "Server error", content = @Content)
//    })
//    public ResponseEntity<User> updateUser(@PathVariable("id")
//                                           @Parameter(name = "id",
//                                                   description = "User ID",
//                                                   example = "1")
//                                           Long id, @RequestBody @Valid User user) {
//        userService.update(id, user);
//        return ResponseEntity.ok().body(user);
//    }
    @Operation(description = "Delete an User by ID")
    @ApiResponse(responseCode = "200", description = "User deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") Long id){
        userService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
