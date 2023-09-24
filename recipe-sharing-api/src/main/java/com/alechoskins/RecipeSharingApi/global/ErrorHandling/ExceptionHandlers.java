package com.alechoskins.RecipeSharingApi.global.ErrorHandling;

import com.alechoskins.RecipeSharingApi.global.ErrorHandling.exceptions.UsernameAlreadyExistsException;
import com.alechoskins.RecipeSharingApi.services.Authentication.IAuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.relation.RoleNotFoundException;

@ControllerAdvice
public class ExceptionHandlers {

    @Autowired
    IAuthenticationServices authenticationServices;

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    ResponseEntity<String> handleUsernameAlreadyExists(UsernameAlreadyExistsException e){
        var RESPONSE = new ResponseEntity<>("Username is already in use", HttpStatus.CONFLICT);
        return new ResponseEntity<>("Username is already in use", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    ResponseEntity<String> handleRoleNotFoundException(RoleNotFoundException e){
        return new ResponseEntity<>("System error assigning non existing role to appUser", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<String> handleUsernameNotFoundException(RoleNotFoundException e){
        return new ResponseEntity<>("Username could not be found", HttpStatus.NOT_FOUND);
    }
}
