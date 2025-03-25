package rapdix.websocket.model.response;

import lombok.Data;
import java.util.List;

@Data
public class OrderBookResponse {
    private OrderBookArg arg;
    private OrderBookData data;

    @Data
    public static class OrderBookArg {
        private String channel;
        private String instId;
    }

    @Data
    public static class OrderBookData {
        private Long localTs;
        private Long exchangeTs;
        private Long seqNum;
        private String type;
        private Long preseqNum;
        private String ltp;
        private String ttv;
        private String ttq;
        private String state;
        private List<List<String>> bids;
        private List<List<String>> asks;
        private List<List<String>> trades;
    }
} 