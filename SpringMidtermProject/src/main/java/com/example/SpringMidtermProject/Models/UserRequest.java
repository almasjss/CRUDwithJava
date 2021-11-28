package com.example.SpringMidtermProject.Models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequest {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String login;
    private String password;
    private String role;
}
