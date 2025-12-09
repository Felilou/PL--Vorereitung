package ft_ormapping.converter;

import ft_ormapping.model.Student;
import ft_ormapping.model.StudentIdentifier;
import ft_ormapping.model.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Converter(autoApply = true)
public class StudentIdentifierConverter implements AttributeConverter<StudentIdentifier, String> {

    @Override
    public String convertToDatabaseColumn(@NotNull StudentIdentifier StudentIdentifier) {
        return StudentIdentifier.identifier();
    }

    @Override
    public StudentIdentifier convertToEntityAttribute(@NotEmpty @NotBlank @NotEmpty String s) {
        return new StudentIdentifier(s);
    }

}
