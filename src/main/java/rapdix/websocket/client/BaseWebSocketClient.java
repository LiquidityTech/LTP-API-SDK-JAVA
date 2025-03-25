package rapdix.websocket.client;

import rapdix.websocket.listener.WebSocketMessageListener;

public interface BaseWebSocketClient {
    void connect();
    void disconnect();
    void setMessageListener(WebSocketMessageListener listener);
    boolean isConnected();
    void send(String message);
} 