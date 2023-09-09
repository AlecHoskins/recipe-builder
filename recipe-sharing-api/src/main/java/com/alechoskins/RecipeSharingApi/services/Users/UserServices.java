package com.alechoskins.RecipeSharingApi.services.Users;

import com.alechoskins.RecipeSharingApi.database.pojos.User;
import com.alechoskins.RecipeSharingApi.database.repository.User.IUserRepository;
import com.alechoskins.RecipeSharingApi.global.ErrorHandling.exceptions.UsernameAlreadyExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements IUserServices{

    @Autowired
    IUserRepository userRepository;

    //region METHODS
    @Transactional
    public User create(User user) {
        var userExists = userRepository.existsByUsernameOrEmail(user.getUsername(), user.getEmail());
        if(!userExists){
            return userRepository.save(user);
        }
        throw new UsernameAlreadyExistsException("User already Exists");
    }
    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
    //endregion

    //region QUERIES
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email).orElse(null);
    }
    //endregion
}
