package ft_ormapping.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record StudentIdentifier(
        @NotEmpty @NotBlank @NotEmpty
        String identifier
) {

}
