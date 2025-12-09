package ft_ormapping.converter;

import ft_ormapping.model.InformationEventType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Converter(autoApply = true)
public class InformationEventTypeConverter implements AttributeConverter<InformationEventType, String> {
    @Override
    public String convertToDatabaseColumn(@NotNull InformationEventType informationEventType) {
        return informationEventType.getShortName();
    }

    @Override
    public InformationEventType convertToEntityAttribute(String s) {
        Optional<InformationEventType> optionalInformationEventType = Optional.of(InformationEventType.valueOf(s));
        return optionalInformationEventType.orElseThrow(IllegalArgumentException::new);
    }
}
