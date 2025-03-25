package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class PlaceOrderResponse {
    private String id;
    private String event;
    private String code;
    private String msg;
    private OrderData data;

    @Data
    public static class OrderData {
        private String orderId;
        private String clientOrderId;
    }
} 