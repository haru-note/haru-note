package net.harunote.service;

import lombok.RequiredArgsConstructor;
import net.harunote.controller.response.GoalResponse;
import net.harunote.data.converter.ModelMapConverter;
import net.harunote.exception.WebApiErrerTypeEnum;
import net.harunote.exception.WebApiServiceException;
import net.harunote.goal.GoalService;
import net.harunote.goal.entity.Goal;
import org.springframework.stereotype.Service;

/**
 * @author CodeVillains
 */
@Service
@RequiredArgsConstructor
public class GoalApiService {
    private final GoalService goalService;
    private final ModelMapConverter converter;

    public GoalResponse findById(Long id) {
        Goal goal = goalService.findById(id).orElseThrow(() -> new WebApiServiceException(WebApiErrerTypeEnum.NOTE_NOT_FOUND));
        GoalResponse response = converter.toDto(goal, GoalResponse.class);
        return response;
    }

}
