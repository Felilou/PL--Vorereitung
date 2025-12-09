package ft_ormapping.converter;

import ft_ormapping.model.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Converter(autoApply = true)
public class TeacherIdentifierConverter implements AttributeConverter<TeacherIdentifier, String> {

    @Override
    public String convertToDatabaseColumn(@NotNull TeacherIdentifier teacherIdentifier) {
        return teacherIdentifier.identifier();
    }

    @Override
    public TeacherIdentifier convertToEntityAttribute(@NotEmpty @NotBlank @NotEmpty String s) {
        return new TeacherIdentifier(s);
    }

}
