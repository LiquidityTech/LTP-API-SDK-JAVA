package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class CancelOrdersResponse {
    private String id;
    private String event;
    private String code;
    private String msg;
} 