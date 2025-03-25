package rapdix.model.request.statement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserTradingStatsRequest {
    private String exchange;
    private String businessType;
    private String begin;
    private String end;

}
