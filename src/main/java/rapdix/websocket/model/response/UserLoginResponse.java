package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String event;
    private String code;
    private String msg;
} 