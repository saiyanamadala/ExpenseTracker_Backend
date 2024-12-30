package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.dto.AuthUserDetails;
import com.expense_tracker.Expense_Tracker_Backend.model.Users;
import com.expense_tracker.Expense_Tracker_Backend.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://192.168.1.12:5173")
public class UserService {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public ResponseEntity<String> register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Users>> allUsers() {
        return new ResponseEntity<>(userDetailsRepo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<AuthUserDetails> verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUsername());
            Users authUser = userDetailsRepo.findByUsername(user.getUsername());
            AuthUserDetails authUserDetails = new AuthUserDetails();
            authUserDetails.setToken(token);
            authUserDetails.setUid(authUser.getUid());
            authUserDetails.setEmail(authUser.getEmail());
            authUserDetails.setUsername(authUser.getUsername());
            return new ResponseEntity<>(authUserDetails, HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
    }
}
