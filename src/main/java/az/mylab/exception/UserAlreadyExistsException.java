package az.mylab.exception;

import az.mylab.enums.ErrorCode;

public class UserAlreadyExistsException extends RuntimeException{

    private final ErrorCode errorCode;

    public UserAlreadyExistsException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;

    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
