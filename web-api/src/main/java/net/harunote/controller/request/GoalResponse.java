package net.harunote.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author CodeVillains
 */
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoalResponse {
    @Schema(description = "목표 ID", type = "long", example = "10901")
    private Long goalId;

    @Schema(description = "노트 타입", type = "String", example = "MANDALART")
    private String type;

    @Schema(description = "목표명", type = "String", example = "하루노트 앱 출시")
    private String title;

    @Schema(description = "삭제 여부", type = "Boolean", example = "false")
    private boolean deleted;


    @Schema(description = "목표 공유 여부", type = "Boolean", example = "false")
    private boolean shared;


    @Schema(description = "목표 완료 여부", type = "Boolean", example = "false")
    private boolean completed;


    @Schema(description = "사용자 ID", type = "Long", example = "10901")
    private Long userId;


    @Schema(description = "시작 일시", type = "DateTime", example = "2023-02-03T10:15:30")
    private LocalDateTime startAt;

    @Schema(description = "목표 완료 일시", type = "DateTime", example = "2023-02-03T10:15:30")
    private LocalDateTime endAt;

    @Schema(description = "작성 일시", type = "DateTime", example = "2023-02-03T10:15:30")
    private LocalDateTime createdAt;

    @Schema(description = "작성자", type = "String", example = "CodeVillains")
    private String createdBy;
}
