package com.tms.taskmanagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotation to generate getters, setters, equals, hashCode, and toString methods.
@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO 
{
    private Long userId;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 50)
    private String userName;

    @Column(nullable = false)
    @NotNull
    @Size(min = 6)
    private String password;
    
    @Column(nullable = false)
    @NotNull
    private String role;

    @Column(nullable = false, unique = true)
    @NotNull
    @Email
    private String email;

    @Column(nullable = false)
    //@ValidPid
    private Long projectId; 

    @Column(nullable = false)
    private String taskStatus;
    
    @NotNull
    private Long taskId;
}