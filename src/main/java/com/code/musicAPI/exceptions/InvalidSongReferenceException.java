package com.code.musicAPI.exceptions;

public class InvalidSongReferenceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidSongReferenceException(String errorMessage) {
        super(errorMessage);
    }

}
