package rapdix.model.vo.position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionsVO {
    private String sym;
    private String orderId;
    private String positionSide;
    private String success;
    private String errorMsg;
}
