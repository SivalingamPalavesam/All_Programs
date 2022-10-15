package com.java.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerClass  extends RuntimeException
{

	public ExceptionHandlerClass() {
        super();
    }

    public ExceptionHandlerClass(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ExceptionHandlerClass(final String message) {
        super(message);
    }

    public ExceptionHandlerClass(final Throwable cause) {
        super(cause);
    }


}
