package net.harunote.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Schema(description = "응답 데이터")
public class ResponseData<T> {
    @Schema(description = "데이터")
    private T data;
    @Schema(description = "상태", example = "200")
    private int status;
    @Schema(description = "성공여부", example = "true")
    private Boolean success;
    @Schema(description = "응답 메시지", example = "OK")
    private String message;
    @Schema(description = "응답일시")
    private LocalDateTime dateTime;
    @Schema(description = "에러코드", example = "NOT_ALLOWED_USER")
    private String errorCode;
    @Schema(description = "에러 메시지", example = "허용되지 않은 사용자 입니다.")
    private String errorMessage;

    public ResponseData() {
    }

    public ResponseData(HttpStatus status) {
        this.status = status.value();
    }

    public ResponseData(T data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
        this.dateTime = LocalDateTime.now();
    }

    public ResponseData(T data, HttpStatus status, String message) {
        this.data = data;
        this.status = status.value();
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

    public ResponseData(HttpStatus status, Boolean isSuccess) {
        this.status = status.value();
        this.success = isSuccess;
        this.dateTime = LocalDateTime.now();
    }

    public ResponseData(T data, HttpStatus status, Boolean isSuccess) {
        this.data = data;
        this.status = status.value();
        this.success = isSuccess;
        this.dateTime = LocalDateTime.now();
    }

    public ResponseData(T data, HttpStatus status, String message, Boolean isSuccess) {
        this.data = data;
        this.status = status.value();
        this.message = message;
        this.success = isSuccess;
        this.dateTime = LocalDateTime.now();
    }

    public ResponseData(T data, HttpStatus status, String message, Boolean isSuccess, String errorCode, String errorMessage) {
        this.data = data;
        this.status = status.value();
        this.message = message;
        this.success = isSuccess;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.dateTime = LocalDateTime.now();
    }

    public static ResponseData onSuccess() {
        return new ResponseData(HttpStatus.OK, Boolean.TRUE);
    }

    public static ResponseData onSuccess(HttpStatus status) {
        return new ResponseData(status, Boolean.TRUE);
    }

    public static <T> ResponseData<T> onSuccess(T data) {
        return new ResponseData(data, HttpStatus.OK, Boolean.TRUE);
    }


    public static <T> ResponseData<T> onSuccess(T data, HttpStatus status) {
        return new ResponseData<>(data, status, Boolean.TRUE);
    }


    public static <T> ResponseData<T> onFail(T data) {
        return new ResponseData<>(data, HttpStatus.OK, HttpStatus.BAD_REQUEST.getReasonPhrase(), Boolean.FALSE);
    }

    public static <T> ResponseData<T> onFail(T data, String errorMessage) {
        return new ResponseData<>(data, HttpStatus.OK, errorMessage, Boolean.FALSE);
    }


    public static <T> ResponseData<T> onFail(T data, HttpStatus status, String message) {
        return new ResponseData<>(data, status, message, Boolean.FALSE);
    }

    public static <T> ResponseData<T> onFail(T data, HttpStatus status, String errorCode, String errorMessage) {
        return new ResponseData<>(data, status, status.toString(), Boolean.FALSE, errorCode, errorMessage);
    }

    public static ResponseData onFail(HttpStatus status, String message) {
        return new ResponseData(null, status, message);
    }

    public static ResponseData onFail(HttpStatus status, String errorCode, String message) {
        return new ResponseData<>(null, status, status.toString(), Boolean.FALSE, errorCode, message);
    }

    public static ResponseData onFail(HttpStatus status) {
        return new ResponseData(status, Boolean.FALSE);
    }

    public static ResponseData onFail(String errorCode, String errorMessage ) {
        return new ResponseData(null, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(),
                false, errorCode, errorMessage);
    }

}
