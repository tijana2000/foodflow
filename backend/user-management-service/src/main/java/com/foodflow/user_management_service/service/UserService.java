package com.foodflow.user_management_service.service;

import com.foodflow.user_management_service.dto.LoginRequestDTO;
import com.foodflow.user_management_service.dto.LoginResponseDTO;
import com.foodflow.user_management_service.dto.RegisterRequestDTO;
import com.foodflow.user_management_service.dto.UserDTO;
import com.foodflow.user_management_service.mapper.UserMapper;
import com.foodflow.user_management_service.model.Role;
import com.foodflow.user_management_service.model.User;
import com.foodflow.user_management_service.repository.RoleRepository;
import com.foodflow.user_management_service.repository.UserRepository;
import com.foodflow.user_management_service.service.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserDTO register(RegisterRequestDTO request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        Role role = roleRepository.findByName(request.getRole())
                .orElseGet(() -> roleRepository.save(new Role(request.getRole())));
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.setRoles(Set.of(role));

        User savedUser = userRepository.save(user);
        return UserMapper.toUserDTO(savedUser);
    }

   public LoginResponseDTO login(LoginRequestDTO request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponseDTO(token, UserMapper.toUserDTO(user));
   }

   public UserDTO getUserByEmail(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toUserDTO(user);
   }
}
