package rapdix.websocket.client;

import com.alibaba.fastjson.JSON;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rapdix.websocket.listener.DefaultWebSocketMessageListener;
import rapdix.websocket.listener.WebSocketMessageListener;
import rapdix.websocket.model.request.*;
import rapdix.util.AuthUtil;

import java.net.URI;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class UserWebSocketClient {
    private static final Logger logger = LoggerFactory.getLogger(UserWebSocketClient.class);
    private static final String WS_URL = "wss://wss.liquiditytech.com/v1/private";

    private final String apiKey;
    private final String secretKey;
    private WebSocketMessageListener messageListener;
    private WebSocketClient client;
    private ScheduledExecutorService pingExecutor;
    private volatile boolean isConnected;

    public UserWebSocketClient(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.messageListener = new DefaultWebSocketMessageListener();
        this.pingExecutor = Executors.newSingleThreadScheduledExecutor();
        initWebSocketClient();
    }

    private void initWebSocketClient() {
        try {
            client = new WebSocketClient(new URI(WS_URL)) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    isConnected = true;
                    messageListener.onConnected();
                    login();
                    startPingScheduler();
                }

                @Override
                public void onMessage(String message) {
                    messageListener.onMessage(message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    isConnected = false;
                    stopPingScheduler();
                    messageListener.onDisconnected(code, reason);
                }

                @Override
                public void onError(Exception ex) {
                    messageListener.onError(ex);
                }
            };
        } catch (Exception e) {
            logger.error("Failed to initialize WebSocket client", e);
            throw new RuntimeException("Failed to initialize WebSocket client", e);
        }
    }

    public void connect() {
        try {
            client.connectBlocking();
        } catch (Exception e) {
            logger.error("Failed to connect to WebSocket", e);
            throw new RuntimeException("Failed to connect to WebSocket", e);
        }
    }

    public void disconnect() {
        if (client != null) {
            stopPingScheduler();
            client.close();
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setMessageListener(WebSocketMessageListener listener) {
        this.messageListener = listener != null ? listener : new DefaultWebSocketMessageListener();
    }

    public void send(String message) {
        if (client != null && client.isOpen()) {
            client.send(message);
        }
    }

    private void login() {
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        String message = timestamp + "GET" + "/users/self/verify";
        String sign = AuthUtil.getWebSocketLoginSign(message, secretKey);

        UserLoginRequest.LoginArgs loginArgs = UserLoginRequest.LoginArgs.builder()
                .apiKey(apiKey)
                .timestamp(timestamp)
                .sign(sign)
                .build();

        UserLoginRequest loginRequest = UserLoginRequest.builder()
                .action("login")
                .args(loginArgs)
                .build();

        String jsonRequest = JSON.toJSONString(loginRequest);
        send(jsonRequest);
    }

    private void startPingScheduler() {
        pingExecutor.scheduleAtFixedRate(() -> {
            if (isConnected) {
                send("ping");
            }
        }, 10, 10, TimeUnit.SECONDS);
    }

    private void stopPingScheduler() {
        if (pingExecutor != null) {
            pingExecutor.shutdown();
            try {
                if (!pingExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
                    pingExecutor.shutdownNow();
                }
            } catch (InterruptedException e) {
                pingExecutor.shutdownNow();
            }
        }
    }

    /**
     * Place order
     *
     * @param request Order request
     */
    public void placeOrder(PlaceOrderRequest request) {
        if (!isConnected) {
            throw new RuntimeException("WebSocket not connected");
        }

        String jsonRequest = JSON.toJSONString(request);
        send(jsonRequest);
    }

    /**
     * Cancel order
     *
     * @param request Cancel order request
     */
    public void cancelOrder(CancelOrderRequest request) {
        if (!isConnected) {
            throw new RuntimeException("WebSocket not connected");
        }

        String jsonRequest = JSON.toJSONString(request);
        send(jsonRequest);
    }

    /**
     * Cancel all orders
     *
     * @param request Cancel all orders request
     */
    public void cancelOrders(CancelOrdersRequest request) {
        if (!isConnected) {
            throw new RuntimeException("WebSocket not connected");
        }

        String jsonRequest = JSON.toJSONString(request);
        send(jsonRequest);
    }

    /**
     * Cancel all orders for specific exchange type
     *
     * @param exchangeType Exchange type
     */
    public void cancelOrders(String exchangeType) {
        if (!isConnected) {
            throw new RuntimeException("WebSocket not connected");
        }

        CancelOrdersRequest.CancelOrdersArgs args = CancelOrdersRequest.CancelOrdersArgs.builder()
                .exchangeType(exchangeType)
                .build();

        CancelOrdersRequest request = CancelOrdersRequest.builder()
                .id(String.valueOf(System.currentTimeMillis()))
                .args(args)
                .build();

        String jsonRequest = JSON.toJSONString(request);
        send(jsonRequest);
    }

    /**
     * Replace order
     *
     * @param request Replace order request
     */
    public void replaceOrder(ReplaceOrderRequest request) {
        if (!isConnected) {
            throw new RuntimeException("WebSocket not connected");
        }

        String jsonRequest = JSON.toJSONString(request);
        send(jsonRequest);
    }
}