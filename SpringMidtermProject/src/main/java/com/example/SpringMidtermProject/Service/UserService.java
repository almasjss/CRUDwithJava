package com.example.SpringMidtermProject.Service;

import com.example.SpringMidtermProject.Entity.User;
import com.example.SpringMidtermProject.Helpers.PasswordValidationHelper;
import com.example.SpringMidtermProject.Helpers.ValidateHelper;
import com.example.SpringMidtermProject.Models.UserRequest;
import com.example.SpringMidtermProject.Repository.CakesRepository;
import com.example.SpringMidtermProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CakesRepository cakesRepository;

    public boolean saveUser(UserRequest userRequest) {
        if (!ValidateHelper.validatePhoneNumber(userRequest.getPhoneNumber())) {
            return false;
        }

        User byPhoneNumber = userRepository.findByPhoneNumber(userRequest.getPhoneNumber());
        User byLogin = userRepository.findByLogin(userRequest.getLogin());
        if (byLogin != null || byPhoneNumber != null) {
            return false;
        }

        if (!PasswordValidationHelper.passwordValidation(userRequest.getPassword())) {
            return false;
        }
        User user = new User(userRequest.getFirstName(), userRequest.getLastName(),
                userRequest.getPhoneNumber(), userRequest.getLogin(), userRequest.getPassword());
        userRepository.save(user);
        return true;
    }

    public User getUser(Integer userId) {
        return userRepository.findById(userId.longValue()).orElse(null);
    }


public boolean updateUser(UserRequest userRequest){
        if(!ValidateHelper.validatePhoneNumber(userRequest.getPhoneNumber() )){
            return false;
        }
        if (!PasswordValidationHelper.passwordValidation(userRequest.getPassword())){
            return false;
        }
        Optional<User> userOptional =userRepository.findById(userRequest.getUserId().longValue());
        User user = userOptional.orElse(null);
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId.longValue());
        User user = userOptional.orElse(null);
        userRepository.delete(user);
        return true;
    }


}
