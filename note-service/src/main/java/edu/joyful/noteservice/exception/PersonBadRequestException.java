package edu.joyful.noteservice.exception;

public class PersonBadRequestException extends RuntimeException {

    public PersonBadRequestException(String msg) {
        super(msg);
    }
}
