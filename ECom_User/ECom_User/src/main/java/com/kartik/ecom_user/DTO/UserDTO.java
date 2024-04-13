package com.kartik.ecom_user.DTO;

import com.kartik.ecom_user.Models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private String email;
    private Set<Role> roles;
}
