package net.harunote.handler;

import lombok.extern.slf4j.Slf4j;
import net.harunote.data.ResponseData;
import net.harunote.exception.WebApiServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author CodeVillains
 */
@RestControllerAdvice
@Slf4j
public class WebApiExceptionHandlerAdvice {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseData> handleException(Exception ex) {
        log.error("[Exception Handler] message : {}", ex.getMessage(), ex);
        ResponseData responseData = ResponseData.onFail(null, HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.name(), "서버에서 에러가 발생했습니다.");
        return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({WebApiServiceException.class})
    public ResponseEntity<ResponseData> handleException(WebApiServiceException ex) {
        log.error("[WebApiException Handler] message : {} , errorStatusCode = {}", ex.getErrorMessage(), ex.getErrorStatusCode(), ex);
        ResponseData responseData = ResponseData.onFail(null, HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getErrorCode(), ex.getErrorMessage());
        return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    @ResponseBody
//    @ExceptionHandler(HaruNoteNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    String goalNotFoundException(HaruNoteNotFoundException ex) {
//        return ex.getMessage();
//    }
}
