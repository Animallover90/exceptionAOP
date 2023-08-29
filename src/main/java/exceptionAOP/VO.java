package exceptionAOP;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class VO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(unique = true)
    private String password;

    @Builder
    public VO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public VO() {

    }
}
