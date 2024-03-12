package com.example.ApiRestSpringBootMysql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InstrumentosBadRequestException extends InstrumentosException {
    public InstrumentosBadRequestException(String mensaje) {
        super(mensaje);
    }
}
