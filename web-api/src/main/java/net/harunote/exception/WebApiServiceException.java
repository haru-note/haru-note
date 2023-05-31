package net.harunote.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebApiServiceException extends RuntimeException {
    private int errorStatusCode;
    private String errorCode;
    private String errorMessage;

    public WebApiServiceException(WebApiErrerTypeEnum errorType) {
        this.errorStatusCode = errorType.getErrorCode();
        this.errorCode = errorType.name();
        this.errorMessage = errorType.getErrorMessage();
    }
}
