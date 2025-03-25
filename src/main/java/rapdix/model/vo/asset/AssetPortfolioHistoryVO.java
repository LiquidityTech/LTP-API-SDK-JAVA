package rapdix.model.vo.asset;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetPortfolioHistoryVO {
    private String id;
    private String currency;
    private String clientOrderId;
    private String amount;
    private String amountReceived;
    private String networkFee;
    private String network;
    private String txld;
    private String fromTradeAccountId;
    private String toTradeAccountId;
    private String fromAccountType;
    private String toAccountType;
    private String status;
    private String type;
    private String createdAt;
}
