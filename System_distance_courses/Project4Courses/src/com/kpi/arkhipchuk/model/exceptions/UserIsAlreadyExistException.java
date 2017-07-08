package com.kpi.arkhipchuk.model.exceptions;

/**
 * Created by Anya on 02.07.2017.
 */
public class UserIsAlreadyExistException extends Throwable {
    public UserIsAlreadyExistException() {
    }
    public UserIsAlreadyExistException(String message) {
        super(message);
    }
}
