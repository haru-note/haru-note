package net.harunote.controller;

import lombok.extern.slf4j.Slf4j;
import net.harunote.controller.response.GoalResponse;
import net.harunote.data.ResponseData;
import net.harunote.service.GoalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CodeVillains
 */
@Slf4j
@RestController
public class GoalController {

    private final GoalApiService goalApiService;

    public GoalController(GoalApiService goalApiService) {
        this.goalApiService = goalApiService;
    }

    @GetMapping("/goal/{id}")
    public ResponseData<GoalResponse> getGoal(@PathVariable Long id) {
        GoalResponse response = goalApiService.findById(id);
        return ResponseData.onSuccess(response);
    }

}
