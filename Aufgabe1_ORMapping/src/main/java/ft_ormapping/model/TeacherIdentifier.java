package ft_ormapping.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record TeacherIdentifier(
        @NotEmpty @NotBlank @NotEmpty
        String identifier
) {

}
