package rapdix.model.request.asset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PortfolioFundsHistoryRequest {
    private String currency;
    private Integer type;
    private Integer status;
    private Long startTime;
    private Long endTime;
    private Integer page;
    private Integer pageSize;
}
