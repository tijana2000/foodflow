package com.foodflow.user_management_service.controller;

import com.foodflow.user_management_service.dto.LoginRequestDTO;
import com.foodflow.user_management_service.dto.LoginResponseDTO;
import com.foodflow.user_management_service.dto.RegisterRequestDTO;
import com.foodflow.user_management_service.dto.UserDTO;
import com.foodflow.user_management_service.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
@PostMapping("/register")
public UserDTO register(@RequestBody RegisterRequestDTO request){
        return userService.register(request);
}

@PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request){
        return userService.login(request);
}
@GetMapping("/test")
    public String test(){
        return "JWT protected endpoint works!";
}
@GetMapping("/me")
    public UserDTO getCurrentUser(Authentication authentication){
        String email = authentication.getName();
        return userService.getUserByEmail(email);
}
}
