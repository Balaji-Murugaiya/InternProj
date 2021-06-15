package com.internproject.notificationsystem.ControllerAdvice;


import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(Exception ex)
    {
        return new ErrorResponse(400,"Bad Request") ;
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse resourceNotFound(Exception ex)
    {
        return new ErrorResponse(404 , "User name not found") ;
    }

    @ExceptionHandler(value={ResponseStatusException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse failedAuthentication(Exception ex)
    {
        return new ErrorResponse(401 , "Password is wrong") ;
    }

    @ExceptionHandler(value={AuthorizationServiceException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse unauthorizedRequest(Exception ex)
    {
        return new ErrorResponse(401,"Unauthorized request") ;
    }


}
