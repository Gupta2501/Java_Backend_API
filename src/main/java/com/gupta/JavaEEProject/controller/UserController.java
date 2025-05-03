package com.gupta.JavaEEProject.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gupta.JavaEEProject.data.domain.User;
import com.gupta.JavaEEProject.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getuser")
    ResponseEntity<User> getUser(@RequestParam("email") String email) {
        return userService.getUser(email);
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping("/deleteuser")
    private void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/edituser/{email}")
    private ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("email") String email){
        return userService.editUser(user,email);
    }
}
