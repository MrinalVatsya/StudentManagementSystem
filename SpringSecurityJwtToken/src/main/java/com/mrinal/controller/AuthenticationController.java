package com.mrinal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrinal.config.JwtTokenUtil;
import com.mrinal.model.LoginUser;
import com.mrinal.model.User;
import com.mrinal.service.UserService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public void register(@RequestBody LoginUser loginUser, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
 
        System.out.println(request.getRemoteAddr());
        SecurityContextHolder.getContext().setAuthentication(authentication);	
        final User user = userService.findOne(loginUser.getUsername());
        final String accessToken = jwtTokenUtil.generateToken(user);
        final String refreshToken = jwtTokenUtil.createRefreshToken(user);
        
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token", accessToken);
        tokenMap.put("refreshToken", refreshToken);
       // return ResponseEntity.ok(new AuthToken(token));
        response.setStatus(HttpStatus.OK.value());	
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), tokenMap);
    }

}
