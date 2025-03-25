package rapdix.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author axia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionVO {

    private String transactionId;
    private String portfolioId;
    private String orderId;
    private String exchangeType;
    private String businessType;
    private String sym;
    private String side;
    @Builder.Default
    private String quantity = "";
    @Builder.Default
    private String price = "";
    @Builder.Default
    private String tradingFee = "";
    private String tradingFeeCoin;
    private String rpnl;
    private String clientOrderId;
    private String algoOrderId;

    private String createAt;

    private String execType;

}
