package com.kartik.ecom_user.Service;

import com.kartik.ecom_user.DTO.UserDTO;
import com.kartik.ecom_user.Exceptions.InvalidCredentialException;
import com.kartik.ecom_user.Exceptions.InvalidTokenException;
import com.kartik.ecom_user.Exceptions.UserNotFoundException;
import com.kartik.ecom_user.Mapper.UserEntityDTOMapper;
import com.kartik.ecom_user.Models.Session;
import com.kartik.ecom_user.Models.SessionStatus;
import com.kartik.ecom_user.Models.User;
import com.kartik.ecom_user.Repository.SessionRepository;
import com.kartik.ecom_user.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SessionRepository sessionRepository;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, SessionRepository sessionRepository){
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.sessionRepository=sessionRepository;
    }

    public ResponseEntity<UserDTO> signup(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        User saveduser = userRepository.save(user);
        UserDTO userDTO = UserEntityDTOMapper.ConvertUsertoUserDTO(saveduser);
        return ResponseEntity.ok(userDTO);
    }

    public ResponseEntity<UserDTO> login(String email, String password){
        Optional<User> optionaluser = userRepository.findByEmail(email);
        if(optionaluser.isEmpty()){
            throw new UserNotFoundException("User does not exist");
        }
        User user = optionaluser.get();

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())){
            throw new InvalidCredentialException("Invalid password");
        }

        //String token = "XYZ";
        MacAlgorithm algorithm = Jwts.SIG.HS256;
        SecretKey key = algorithm.key().build();
        Map<String,Object> jsonForJWT = new HashMap<>();
        jsonForJWT.put("userID", user.getId());
        //jsonForJWT.put("role",user.getRoles());
        jsonForJWT.put("createdAt",new Date());
        jsonForJWT.put("expiryAt",new Date(LocalDate.now().plusDays(3).toEpochDay()));

        //We have declared token as a string. Hence, we convert above data to string and put in token
        String token = Jwts.builder().claims(jsonForJWT).signWith(key,algorithm).compact();

        Session session = new Session();
        session.setUser(user);
        session.setLoginAt(new Date());
        session.setToken(token);
        session.setSessionStatus(SessionStatus.ACTIVE);
        sessionRepository.save(session);

        UserDTO userDTO = UserEntityDTOMapper.ConvertUsertoUserDTO(user);


        //ResponseEntity consists of 3 parts: Payload, header and HTTP status.
        // Token must be sent back in header not in payload
        
        MultiValueMapAdapter<String,String> header = new MultiValueMapAdapter<>(new HashMap<>());
        header.add(HttpHeaders.SET_COOKIE,token);

        return new ResponseEntity<UserDTO>(userDTO,header, HttpStatus.OK);

    }

    public SessionStatus validate(Long userId, String token){
        Optional<Session> session = sessionRepository.findByUserIdAndToken(userId,token);
        if(session.isEmpty() || session.get().getSessionStatus().equals(SessionStatus.ENDED))
            throw new InvalidTokenException("token is invalid");

        return SessionStatus.ACTIVE;

    }

    public ResponseEntity<Void> logout(Long userId, String token){
        Optional<Session> sessionOptional = sessionRepository.findByUserIdAndToken(userId,token);
        if(sessionOptional.isEmpty())
            return null;

        Session session =sessionOptional.get();
        session.setSessionStatus(SessionStatus.ENDED);
        sessionRepository.save(session);
        return ResponseEntity.ok().build();

    }





}
