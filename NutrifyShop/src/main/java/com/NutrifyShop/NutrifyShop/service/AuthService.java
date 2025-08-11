package com.NutrifyShop.NutrifyShop.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NutrifyShop.NutrifyShop.repository.UserRepository;
import com.NutrifyShop.NutrifyShop.model.User;;
@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    public User Login(String email,String password){
        Optional<User> user=userRepository.findByEmail(email);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                return user.get();
            }
        }
        return null;
    }
    public User Register(User tempuser){

        Optional<User> existingUser = userRepository.findByEmail(tempuser.getEmail());
        if(existingUser.isPresent()){
            return null; // User already exists
        }

        return userRepository.save(tempuser);
    }
}
