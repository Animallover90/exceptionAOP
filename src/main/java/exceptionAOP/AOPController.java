package exceptionAOP;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AOPController {

    private final AOPService aopService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // unique한 컬럼에 같은 값을 넣는 에러 발생시키기
    @GetMapping("/save")
    public String save() {
        VO vo = VO.builder()
                .name("abc")
                .password("def")
                .build();
        aopService.save(vo);
        aopService.save(vo);
        return "save";
    }

    @GetMapping("/find")
    public String find() {
        aopService.findById(1L);
        return "find";
    }

    // Throwable 에러를 Repository에서 발생시키기
    @GetMapping("throw")
    public String th() throws Throwable {
        aopService.throwable();
        return "index";
    }
}
