package net.harunote.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CodeVillains
 */

@Slf4j
@RestController
public class IndexController {
    @GetMapping("/hello")
    public String getHello() {
        String helloWorld = "안녕하세요.";
        log.info("##### getHello = {}", helloWorld);

        return helloWorld;
    }
}
