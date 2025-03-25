package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class MarkPriceResponse {
    private String channel;
    private Long localTs;
    private String instId;
    private String markPrice;
} 