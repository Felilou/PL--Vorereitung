package ft_ormapping.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum InformationEventType {
    GUIDED_TOUR("GT"), MAKER_SPACE("MS"), PRESENTATION("PT");

    final String shortName;

    InformationEventType(String shortName) {
        this.shortName = this.name();
    }

}
