/*

package com.revature.controllers;

import com.revature.daos.UserDAO;
import com.revature.daos.RoleDAO;
import com.revature.dto.AuthDTO;
import com.revature.dto.LoginDTO;
import com.revature.dto.RegisterDTO;
import com.revature.models.User;
import com.revature.models.Role;
import com.revature.security.TokenGenerator;
//import com.revature.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDAO userDAO;
    private final RoleDAO roleDao;
    private final PasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDAO userDAO, RoleDAO roleDao, PasswordEncoder passwordEncoder, TokenGenerator tokenGenerator) {
        this.authenticationManager = authenticationManager;
        this.userDAO = userDAO;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){

        if (UserDAO.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User p = new User();
        p.setFirstName(registerDTO.getFirstName());
        p.setLastName(registerDTO.getLastName());
        p.setUsername(registerDTO.getUsername());
        p.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role role = roleDao.findByRoleTitle("Finance Manager");

        p.setRole(role);

        userDAO.save(p);

        return new ResponseEntity<>("Person successfully registered!", HttpStatus.CREATED);

    }

    @PostMapping("login")
    public ResponseEntity<AuthDTO> login(@RequestBody LoginDTO loginDTO){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenGenerator.generateToken(authentication);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<AuthDTO>(new AuthDTO(token), HttpStatus.OK);

    }


}

 */



package com.revature.controllers;

import com.revature.daos.UserDAO;
import com.revature.daos.RoleDAO;
import com.revature.dto.AuthDTO;
import com.revature.dto.LoginDTO;
import com.revature.dto.RegisterDTO;
import com.revature.models.User;
import com.revature.models.Role;
import com.revature.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDAO userDAO;
    private final RoleDAO roleDao;
    private final PasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDAO userDAO, RoleDAO roleDao, PasswordEncoder passwordEncoder, TokenGenerator tokenGenerator) {
        this.authenticationManager = authenticationManager;
        this.userDAO = userDAO;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){

        if (UserDAO.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User p = new User();
        p.setFirstName(registerDTO.getFirstName());
        p.setLastName(registerDTO.getLastName());
        p.setUsername(registerDTO.getUsername());
        p.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role role = roleDao.findByRoleTitle("Finance Manager");

        p.setRole(role);

        userDAO.save(p);

        return new ResponseEntity<>("Person successfully registered!", HttpStatus.CREATED);

    }

    @PostMapping("login")
    public ResponseEntity<AuthDTO> login(@RequestBody LoginDTO loginDTO){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenGenerator.generateToken(authentication);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<AuthDTO>(new AuthDTO(token), HttpStatus.OK);

    }

}
