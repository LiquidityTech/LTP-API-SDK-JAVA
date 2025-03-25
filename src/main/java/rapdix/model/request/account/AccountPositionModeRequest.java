package rapdix.model.request.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AccountPositionModeRequest {
    private String exchangeType;
    private String positionMode;
}
