package rapdix.model.request.asset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PortfolioDetailRequest {
    private String exchangeType;
    private Integer pageNum;
    private Integer pageSize;
}
