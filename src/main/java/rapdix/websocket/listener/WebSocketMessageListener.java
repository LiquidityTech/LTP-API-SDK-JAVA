package rapdix.websocket.listener;

public interface WebSocketMessageListener {
    void onMessage(String message);
    void onConnected();
    void onDisconnected(int code, String reason);
    void onError(Throwable throwable);
} 