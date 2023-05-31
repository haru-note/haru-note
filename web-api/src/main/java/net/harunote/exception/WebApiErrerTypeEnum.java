package net.harunote.exception;

import lombok.Getter;

@Getter
public enum WebApiErrerTypeEnum {
    /**
     * 아래는 샘플 에러 유형
     */
    NOTE_NOT_FOUND(1004, "잘못된 접근입니다. 노트가 존재하지 않습니다."),
    NOT_ALLOWED_USER(1005, "허용되지 않은 사용자 입니다.");

    int errorCode;
    String errorMessage;

    WebApiErrerTypeEnum(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
