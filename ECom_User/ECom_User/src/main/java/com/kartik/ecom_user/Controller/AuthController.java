package com.kartik.ecom_user.Controller;

import com.kartik.ecom_user.DTO.LoginRequestDTO;
import com.kartik.ecom_user.DTO.SignUpRequestDTO;
import com.kartik.ecom_user.DTO.UserDTO;
import com.kartik.ecom_user.DTO.ValidateTokenRequestDTO;
import com.kartik.ecom_user.Models.SessionStatus;
import com.kartik.ecom_user.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody SignUpRequestDTO signUpRequestDTO){
        return authService.signup(signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return authService.login(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validate(@RequestBody ValidateTokenRequestDTO validateTokenRequestDTO){
        SessionStatus sessionStatus = authService.validate(validateTokenRequestDTO.getUserID(), validateTokenRequestDTO.getToken());
        return new ResponseEntity<>(sessionStatus, HttpStatus.OK);
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<Void> logout(@PathVariable("id") Long userId, @RequestHeader("token") String token)
    {
        return authService.logout(userId,token);
    }



}
