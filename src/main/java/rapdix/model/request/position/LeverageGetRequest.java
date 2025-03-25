package rapdix.model.request.position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LeverageGetRequest {
    private String sym;
}
