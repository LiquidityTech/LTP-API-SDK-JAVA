package rapdix.model.vo.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionRecordVO {
    private String userId;
    private String portfolioId;
    private String subPortfolioId;
    private String exchangeType;
    private String businessType;
    private String transactionId;
    private String coin;
    private String sym;
    private String feePrice;
    private String amount;
    private String status;
    private String createdAt;
}
