package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class BBOResponse {
    private String instId;
    private String channel;
    private Long localTs;
    private Long exchangeTs;
    private Long seqNum;
    private String exchange;
    private PriceLevel bid;
    private PriceLevel ask;

    @Data
    public static class PriceLevel {
        private String price;
        private String qty;
    }
} 