package com.example.SpringMidtermProject.Repository;


import com.example.SpringMidtermProject.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Integer userId);
    User findByLogin(String login);
    User findByPhoneNumber(String phoneNumber);
    //    void updateUser(User user);
    void deleteUserById(Integer userId);
}
