package net.harunote.controller;

import lombok.extern.slf4j.Slf4j;
import net.harunote.data.ResponseData;
import net.harunote.controller.request.GoalResponse;
import net.harunote.service.MainApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CodeVillains
 */

@Slf4j
@RestController
public class MainController {

    private final MainApiService mainApiService;

    public MainController(MainApiService mainApiService) {
        this.mainApiService = mainApiService;
    }

    @GetMapping("/hello")
    public String getHello() {
        String helloWorld = "안녕하세요.";
        log.info("##### getHello = {}", helloWorld);

        return helloWorld;
    }

    @GetMapping("/goal/{id}")
    public ResponseData<GoalResponse> getGoal(@PathVariable Long id) {
        GoalResponse response = mainApiService.findById(id);
        return ResponseData.onSuccess(response);
    }

}
