package rapdix.model.request.position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PositionCloseRequest {
    private String sym;
    private String positionSide;
}
