package com.foodflow.user_management_service.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    private Boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String fullName,String email, String password, Boolean active){
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.active = active;
    }
    public Long getId(){
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public Boolean getActive(){
        return active;
    }
    public Set<Role> getRoles(){
        return roles;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
