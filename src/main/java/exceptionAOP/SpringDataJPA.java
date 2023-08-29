package exceptionAOP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SpringDataJPA extends JpaRepository<VO, Long> {

    Optional<VO> findByName(String name);
    Optional<VO> findByPassword(String password);

}
