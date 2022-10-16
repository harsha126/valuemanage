package com.valuemanage.services;

import com.valuemanage.domain.User;
import com.valuemanage.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public void saveNewUser(User user) {
        User t = userRepository.findByUsername(user.getUsername().trim());
        if(t != null) log.info("User with username {}",user.getUsername());
        else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    @Override
    public void saveNewUser(String username, String password, String role, Long uid) {
        User t = userRepository.findByUsername(username.trim());
        if(t!=null) log.info("User with username {}",username);
        else{
            User newUser = User.builder().username(username).password(passwordEncoder.encode(password)).role(role).uid(uid).build();
            userRepository.save(newUser);
            log.info("Saved a new User with username : {} , password : {} , role : {} and uid : {}",username,password,role,uid);
        }
    }
}
