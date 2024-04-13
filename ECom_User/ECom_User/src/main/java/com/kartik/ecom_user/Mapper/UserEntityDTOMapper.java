package com.kartik.ecom_user.Mapper;

import com.kartik.ecom_user.DTO.UserDTO;
import com.kartik.ecom_user.Models.User;

public class UserEntityDTOMapper {
    public static UserDTO ConvertUsertoUserDTO(User user)
    {
        UserDTO userDto = new UserDTO();
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
