package ${package}.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "${entity}")
public class ${entity} {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "id")
    private long id;

    @Column(name = "stubProp")
    private String stubProp;
}
