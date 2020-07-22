package br.com.pierre.restspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Unsuported extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public Unsuported(String exception){
        super(exception);
    }

}
