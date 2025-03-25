package rapdix.websocket.model.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String id;      // userid，可选
    private String code;    // 错误码
    private String msg;     // 错误信息
    private String event;   // 事件类型，固定为"login"
} 