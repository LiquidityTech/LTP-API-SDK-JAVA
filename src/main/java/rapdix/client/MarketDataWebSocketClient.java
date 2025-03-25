package rapdix.client;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import rapdix.model.websocket.WebSocketRequest;
import rapdix.model.websocket.WebSocketResponse;
import rapdix.util.AuthUtil;

import java.util.concurrent.TimeUnit;

public class MarketDataWebSocketClient {
    private final OkHttpClient client;
    private WebSocket webSocket;
    private final String apiKey;
    private final String secretKey;
    private final String wsUrl;
    private WebSocketListener messageHandler;

    public MarketDataWebSocketClient(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.wsUrl = "wss://mds.liquiditytech.com/v2/public";
        
        this.client = new OkHttpClient.Builder()
                .pingInterval(30, TimeUnit.SECONDS)
                .build();
    }

    public void connect() {
        Request request = new Request.Builder()
                .url(wsUrl)
                .build();

        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("WebSocket onOpen");
                // 连接建立后立即发送登录请求
                sendLoginRequest();
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                System.out.println("onMessage: " + text);
                if (messageHandler != null) {
                    messageHandler.onMessage(webSocket, text);
                }
                
                // 解析响应
                WebSocketResponse response = JSON.parseObject(text, WebSocketResponse.class);
                if ("login".equals(response.getEvent())) {
                    if ("200000".equals(response.getCode())) {
                        System.out.println("login success");
                    } else {
                        System.out.println("login failed: " + response.getMsg());
                    }
                }
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                System.out.println("WebSocket onClosing: " + reason);
                webSocket.close(code, reason);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                System.out.println("WebSocket onClosed: " + reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                System.out.println("WebSocket onFailure: " + t.getMessage());
            }
        });
    }

    private void sendLoginRequest() {
        String timestamp = AuthUtil.gmtNow();
        String sign = AuthUtil.getSign("", secretKey, timestamp);

        WebSocketRequest loginRequest = WebSocketRequest.builder()
                .action("login")
                .args(WebSocketRequest.WebSocketLoginArgs.builder()
                        .apiKey(apiKey)
                        .timestamp(timestamp)
                        .sign(sign)
                        .build())
                .build();

        String loginMessage = JSON.toJSONString(loginRequest);
        webSocket.send(loginMessage);
    }

    public void disconnect() {
        if (webSocket != null) {
            webSocket.close(1000, "Normal closure");
        }
    }

    public void setMessageHandler(WebSocketListener handler) {
        this.messageHandler = handler;
    }
} 