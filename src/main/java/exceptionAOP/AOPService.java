package exceptionAOP;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AOPService {

    private final AOPRepository aopRepository;

    public void save(VO vo) {
        aopRepository.save(vo);
    }

    public Optional<VO> findById(Long id) {
        return aopRepository.findById(id);
    }

    public void throwable() throws Throwable {
        aopRepository.throwable();
    }
}
