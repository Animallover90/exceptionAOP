package exceptionAOP;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AOPRepository {

    private final SpringDataJPA springDataJPA;
    public void save(VO vo) {
        springDataJPA.save(vo);
    }

    public Optional<VO> findById(Long id) {
        return springDataJPA.findById(id);
    }

    public void throwable() throws Throwable {
        throw new Throwable("예상치 못한 에러 발생");
    }
}
