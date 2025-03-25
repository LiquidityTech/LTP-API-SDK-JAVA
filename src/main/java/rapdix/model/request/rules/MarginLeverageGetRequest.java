package rapdix.model.request.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class MarginLeverageGetRequest {
    private String exchangeType;
    private String coin;
    private String page;
    private String pageSize;
}
