package exceptionAOP.aop;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
    private final HttpStatus status;
    private final String code;
    private final String message;

    public static ResponseEntity<ErrorResponse> error(CustomException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorResponse.builder()
                        .status(e.getErrorCode().getStatus())
                        .code(e.getErrorCode().getCode())
                        .message(e.getErrorCode().getMessage())
                        .build());
    }
}
