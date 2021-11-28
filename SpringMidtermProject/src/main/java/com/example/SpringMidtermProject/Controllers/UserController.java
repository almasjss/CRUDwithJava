package com.example.SpringMidtermProject.Controllers;


import com.example.SpringMidtermProject.Constants.Constants;
import com.example.SpringMidtermProject.Entity.User;
import com.example.SpringMidtermProject.Models.UserRequest;
import com.example.SpringMidtermProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequest userRequest) {
        boolean result = userService.saveUser(userRequest);
        if (!result) {
            return new ResponseEntity(Constants.REGISTRATION_FAILED, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userRequest);
    }

    @GetMapping("/user")
    public ResponseEntity getUserById(@RequestParam Integer userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return new ResponseEntity(Constants.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/edit")
    public ResponseEntity updateUser(@RequestBody UserRequest userRequest) {
        boolean result = userService.updateUser(userRequest);
        if (!result) {
            return new ResponseEntity(Constants.EDITING_FAILED, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userRequest);
    }

    @GetMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam Integer userId) {
        boolean result = userService.deleteUser(userId);
        if (!result) {
            return new ResponseEntity(Constants.DELETING_FAILED, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(Constants.DELETED_SUCCESSFULLY, HttpStatus.OK);
    }
}
