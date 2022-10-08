package com.example.transportation_company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.Entity;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    EntityNotFoundException(){
        super("Entity not found");
    }

    EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String EntityName, Long Id){
        super("%s with id %d not found".formatted(EntityName, Id));
    }

}
