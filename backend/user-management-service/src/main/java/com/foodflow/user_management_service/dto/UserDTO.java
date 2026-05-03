package com.foodflow.user_management_service.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private Boolean active;
    private Set<String>roles;

    public UserDTO(){

    }

    public UserDTO(Long id, String fullName,String email,Boolean active, Set<String>roles){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
