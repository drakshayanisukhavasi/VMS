package com.draks.vms.exception;

public class TechnicalException extends Exception {

    private static final long serialVersionUID = -7201296522126409872L;

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException(String message, Throwable cause) {
        super(cause);
    }


    
}
