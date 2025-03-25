package rapdix.model.websocket;

import lombok.Data;

@Data
public class WebSocketResponse {
    private String id;
    private String event;
    private String code;
    private String msg;
} 