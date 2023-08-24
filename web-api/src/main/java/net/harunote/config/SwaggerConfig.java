package net.harunote.config;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import net.harunote.exception.WebApiErrerTypeEnum;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenApiCustomizer getOpenApiCustomizer() {

        return openApi ->
                openApi.getPaths().values().stream()
                        .map(PathItem::readOperations)
                        .flatMap(Collection::stream)
                        .forEach(this::setApiResponsesOnOperation);
    }

    private void setApiResponsesOnOperation(Operation operation) {
        ApiResponses responses = operation.getResponses();

        if ("Error".equals(operation.getSummary())) {
            setErrorCodeDescription(responses);
            return;
        }

        setDefaultResponseCode(responses);
    }

    private void setErrorCodeDescription(ApiResponses responses) {
        Arrays.stream(WebApiErrerTypeEnum.values()).forEach(errorType -> {
            ApiResponse apiResponse = new ApiResponse()
                    .description(errorType.getErrorMessage());

            responses.addApiResponse(String.valueOf(errorType.getErrorCode()), apiResponse);
        });
    }

    private void setDefaultResponseCode(ApiResponses responses) {
        Constants.DESCRIPTION_MAP.forEach((statusCode, description) -> {
            ApiResponse apiResponse = new ApiResponse()
                    .description(description)
                    .content(this.getContentFromConstants(statusCode));

            responses.addApiResponse(statusCode.toString(), apiResponse);
        });
    }

    private Content getContentFromConstants(Integer statusCode) {
        return new Content()
                .addMediaType("application/json", new MediaType().example(Constants.EXAMPLE_MAP.get(statusCode)));
    }

    private static final class Constants {
        static final Map<Integer, String> DESCRIPTION_MAP = Map.of(
                400, "Bad Request",
                401, "Unauthorized",
                403, "Forbidden",
                500, "Internal Server Error"
        );

        static final Map<Integer, String> EXAMPLE_MAP = Map.of(
                400, """
                    {
                        "data": null,
                        "status": 400,
                        "success": false,
                        "message": null,
                        "dateTime": "2020-03-04T14:24:08.050909",
                        "errorCode": -123,
                        "errorMessage": "왜때문인지 입력값이 틀렸네요"
                    }
                    """,
                401, """
                        {
                            "data": null,
                            "status": 401,
                            "success": false,
                            "message": "401 UNAUTHORIZED",
                            "dateTime": "2020-03-09T18:15:33.072751",
                            "errorCode": 405,
                            "errorMessage": "잘못된 웹로그인 토큰 형식"
                        }
                    """,
                403, """
                        {
                            "data": null,
                            "status": 403,
                            "success": false,
                            "message": "403 FORBIDDEN",
                            "dateTime": "2020-03-09T18:15:33.072751",
                            "errorCode": 406,
                            "errorMessage": "포비든"
                        }
                    """,
                500, "Internal Server Error."
        );

        private Constants() {}
    }
}
