package com.NutrifyShop.NutrifyShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NutrifyShop.NutrifyShop.model.LoginUser;
import com.NutrifyShop.NutrifyShop.model.User;
import com.NutrifyShop.NutrifyShop.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginUser tempuser){
        User user=authService.Login(tempuser.email, tempuser.password);
        if(user==null){
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
        return ResponseEntity.ok().body(user);

    }
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody User tempuser){
        User newUser=authService.Register(tempuser);
        if(newUser==null){
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/hello")
    public ResponseEntity<?> Hello(){
        return ResponseEntity.ok().body("Hello from Nutrify Shop");
    }
}
