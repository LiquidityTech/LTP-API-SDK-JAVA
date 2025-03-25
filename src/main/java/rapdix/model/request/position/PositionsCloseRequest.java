package rapdix.model.request.position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PositionsCloseRequest {
    private String symList;
    private String positionSide;
    private String closeAllPos;
    private String exchangeType;

}
