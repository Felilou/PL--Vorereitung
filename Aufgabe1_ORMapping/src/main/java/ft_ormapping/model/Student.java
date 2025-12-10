package ft_ormapping.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Student extends PersonRole {

    @NotNull
    StudentIdentifier identifier;

    @Builder(builderMethodName = "studentBuilder")
    protected Student(Person person, String identifier) {
        super(person);
        this.identifier = new StudentIdentifier(identifier);
    }

}
