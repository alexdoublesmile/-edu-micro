package edu.joyful.noteservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class PersonFeignExceptionHandler implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400: return new PersonBadRequestException("Bad request error from book service");
            default: return new Exception("Library generic exception");
        }
    }
}
