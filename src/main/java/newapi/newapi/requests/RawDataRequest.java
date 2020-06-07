package newapi.newapi.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import newapi.newapi.models.types.LangType;

import java.util.Map;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RawDataRequest {
    private Map<LangType, String> rawData;
}
