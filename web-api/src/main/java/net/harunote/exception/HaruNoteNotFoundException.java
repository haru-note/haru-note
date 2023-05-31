package net.harunote.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HaruNoteNotFoundException extends RuntimeException {

//    public HaruNoteNotFoundException(Long id) {
//        super("잘못된 접근입니다. 노트가 존재하지 않습니다.");
//    }
}