package rapdix.websocket.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequest {
    private String action;
    private LoginArgs args;

    @Data
    @Builder
    public static class LoginArgs {
        private String apiKey;
        private String timestamp;
        private String sign;
    }
} 