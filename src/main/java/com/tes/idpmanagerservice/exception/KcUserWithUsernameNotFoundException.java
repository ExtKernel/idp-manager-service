package com.tes.idpmanagerservice.exception;

public class KcUserWithUsernameNotFoundException extends RuntimeException {
    public KcUserWithUsernameNotFoundException(String message) {
        super(message);
    }

    public KcUserWithUsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KcUserWithUsernameNotFoundException(Throwable cause) {
        super(cause);
    }
}
