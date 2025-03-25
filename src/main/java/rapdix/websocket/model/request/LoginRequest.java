package rapdix.websocket.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    @Builder.Default
    private String action = "login";
    private LoginArgs args;

    @Data
    @Builder
    public static class LoginArgs {
        private String apiKey;
        
        @JSONField(ordinal = 1)
        private String timestamp;
        
        @JSONField(ordinal = 2) 
        private String sign;
    }
} 