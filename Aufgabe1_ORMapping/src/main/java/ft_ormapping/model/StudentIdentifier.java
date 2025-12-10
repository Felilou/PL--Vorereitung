package ft_ormapping.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StudentIdentifier(
        @NotEmpty @NotBlank @NotEmpty
        String identifier
) {

}
