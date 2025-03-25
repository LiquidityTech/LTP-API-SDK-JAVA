package rapdix.model.vo;

import lombok.Data;

@Data
public class ArchiveTransactionVO {
    private String transactionId;
    private String portfolioId;
    private String orderId;
    private String clientOrderId;
    private String exchangeType;
    private String businessType;
    private String sym;
    private String side;
    private String quantity;
    private String price;
    private String tradingFee;
    private String tradingFeeCoin;
    private String execType;
    private String rpnl;
    private String createAt;
} 