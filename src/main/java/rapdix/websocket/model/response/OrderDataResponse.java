package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class OrderDataResponse {
    private String channel;
    private String instId;
    private OrderData data;

    @Data
    public static class OrderData {
        private String portfolioId;
        private String orderId;
        private String clientOrderId;
        private String exchangeType;
        private String businessType;
        private String sym;
        private String limitPrice;
        private String orderQty;
        private String quoteOrderQty;
        private String side;
        private String exchangeOrderType;
        private String timeInForce;
        private String executedQty;
        private String executedAmount;
        private String executedAvgPrice;
        private String lastExecutedQty;
        private String lastExecutedPrice;
        private String lastExecutedAmount;
        private String fee;
        private String feeCoin;
        private String rebate;
        private String rebateCoin;
        private String orderState;
        private String updateAt;
        private String createAt;
        private String borrowAmount;
        private String borrowAsset;
        private String reason;
        private String leverage;
        private String positionSide;
    }
} 