package ft_ormapping.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Teacher extends PersonRole {

    @NotNull
    TeacherIdentifier identifier;

    @Builder(builderMethodName = "teacherBuilder")
    protected Teacher(Person person, String identifier) {
        super(person);
        this.identifier = new TeacherIdentifier(identifier);
    }
}
