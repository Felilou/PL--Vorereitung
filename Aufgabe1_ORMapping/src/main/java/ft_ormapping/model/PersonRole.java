package ft_ormapping.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"identifier"})
})
@Setter
public class PersonRole extends AbstractPersistable<Long> {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    Person person;

    @Builder
    protected PersonRole(Person person) {
        this.person = person;
    }
}
