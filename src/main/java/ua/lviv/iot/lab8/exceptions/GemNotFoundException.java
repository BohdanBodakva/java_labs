package ua.lviv.iot.lab8.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GemNotFoundException extends Exception{
    public GemNotFoundException(String message) {
        super(message);
    }
}

