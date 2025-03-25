package rapdix.model.vo.order;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVO {
    /**
     * The portfolio to which the order belongs
     */
    private String portfolioId;
    /**
     * The name of the portfolio to which the order belongs
     */
    private String portfolioName;
    /**
     * Order number
     */
    private String orderId;
    /**
     * Client order number
     */
    @Builder.Default
    private String clientOrderId = "";
    /**
     * Order state
     */
    private String orderState;
    /**
     * EXCHANGE_BUSINESS_BASE_COUNTER
     */
    @Builder.Default
    private String sym = "";
    /**
     * Order direction
     */
    private String side;
    /**
     * Exchange order type
     */
    private String exchangeOrderType;
    /**
     * Exchange type
     */
    private String exchangeType;

    /**
     * Business type
     */
    private String businessType;

    /**
     * Order quantity
     */
    private String orderQty;
    /**
     * Order amount
     */
    private String quoteOrderQty;
    /**
     * Limit price
     */
    private String limitPrice;
    /**
     * Order validity method
     */
    private String timeInForce;
    /**
     * Order filled quantity
     */
    private String executedQty;
    /**
     * Order filled amount
     */
    private String executedAmount;
    /**
     * Order filled average price
     */
    private String executedAvgPrice;
    /**
     * Failure reason
     */
    private String reason;

    private String createAt;

    private String updateAt;

    /**
     * The actual transaction fee of the order (accumulated from 0)
     */
    private String fee;

    private String feeCoin;

    /**
     * Order type
     */
    private String orderType;
    /**
     * Whether it is a reduceOnly order
     */
    private Boolean reduceOnly;

    /**
     * Leverage for opening a position
     */
    private Integer leverage;

    /**
     * The quantity of the latest trade
     */
    private String lastExecutedQty;
    /**
     * The price of the latest trade
     */
    private String lastExecutedPrice;
    /**
     * The amount of the latest trade
     */
    private String lastExecutedAmount;
    /**
     * Borrowed amount for leverage
     */
    private String borrowAmount;
    /**
     * Currency of borrowed leverage
     */
    private String borrowAsset;

    /**
     * Position direction
     */
    private String positionSide;
    /**
     * Algorithmic order ID
     */
    private String algoOrderId;

    @JsonUnwrapped
    private String algoParam;

    /**
     * Rebate fee
     */
    private String rebate;
    /**
     * Rebate currency
     */
    private String rebateCoin;

    /**
     * Take-profit trigger price
     */
    @Builder.Default
    private String tpTriggerPrice = "";
    /**
     * Take-profit trigger type
     */
    @Builder.Default
    private String tpTriggerType = "";
    /**
     * Take-profit price
     */
    @Builder.Default
    private String tpPrice = "";
    /**
     * Stop-loss trigger price
     */
    @Builder.Default
    private String slTriggerPrice = "";
    /**
     * Stop-loss trigger type
     */
    @Builder.Default
    private String slTriggerType = "";
    /**
     * Stop-loss price
     */
    @Builder.Default
    private String slPrice = "";

//    public void calcFee() {
//        Map<String, String> feeAndRebateMap = CommonUtils.getFeeAndRebate(this.fee, this.feeCoin);
//        this.fee = feeAndRebateMap.get(CommonUtils.FEE_KEY);
//        this.feeCoin = feeAndRebateMap.get(CommonUtils.FEE_COIN_KEY);
//        this.rebate = feeAndRebateMap.get(CommonUtils.REBATE_KEY);
//        this.rebateCoin = feeAndRebateMap.get(CommonUtils.REBATE_COIN_KEY);
//    }

}
