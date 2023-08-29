package exceptionAOP.aop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SUCCESS("200", "OK", HttpStatus.OK),

    // HttpStatus를 정상값으로 하고 받는 쪽에서 처리하도록 code 값을 별도로 전달
    ForbiddenException("403", "해당 요청에 대한 권한이 없습니다.", HttpStatus.OK),
    UnExpectedError("500", "예상치 못한 에러가 발생하였습니다.", HttpStatus.OK),
    ParameterError("453", "파라미터 값에 문제가 있습니다.", HttpStatus.OK), // HttpStatus enum값에 없는 값으로 커스텀 지정

    TransientDataAccess("454", "일시적인 데이터 오류가 발생하였습니다. 다시 시도해주시기 바랍니다.", HttpStatus.OK),
    NonTransientDataAccess("455", "서버 오류가 발생하였습니다. 잠시 후 다시 시도해주시기 바랍니다.", HttpStatus.OK),
    // HttpStatus를 지정
    BadRequestError ("400", "정상적인 요청이 아닙니다.", HttpStatus.BAD_REQUEST),
    ;

    private final String code;
    private final String message;
    private final HttpStatus status;

}
