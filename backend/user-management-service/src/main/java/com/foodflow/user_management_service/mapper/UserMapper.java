package com.foodflow.user_management_service.mapper;

import com.foodflow.user_management_service.dto.UserDTO;
import com.foodflow.user_management_service.model.Role;
import com.foodflow.user_management_service.model.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getActive(),
                user.getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet())
        );
    }
}
