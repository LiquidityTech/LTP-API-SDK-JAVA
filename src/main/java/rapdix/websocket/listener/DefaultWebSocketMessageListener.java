package rapdix.websocket.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import rapdix.websocket.model.response.*;

public class DefaultWebSocketMessageListener implements WebSocketMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(DefaultWebSocketMessageListener.class);

    @Override
    public void onMessage(String message) {
        try {
            // Parse message
            JSONObject json = JSON.parseObject(message);
            
            // Handle subscription response
            if (json.containsKey("event")) {
                if ("login".equals(json.getString("event"))) {
                    UserLoginResponse response = JSON.parseObject(message, UserLoginResponse.class);
                    logger.info("Login response: {}", JSON.toJSONString(response));
                    return;
                }
                
                if ("cancel_order".equals(json.getString("event"))) {
                    CancelOrderResponse response = JSON.parseObject(message, CancelOrderResponse.class);
                    logger.info("Cancel order response: {}", JSON.toJSONString(response));
                    return;
                }
                
                if ("cancel_orders".equals(json.getString("event"))) {
                    CancelOrdersResponse response = JSON.parseObject(message, CancelOrdersResponse.class);
                    logger.info("Cancel all orders response: {}", JSON.toJSONString(response));
                    return;
                }
            }
            
            // Handle user data push
            if (json.containsKey("channel")) {
                String channel = json.getString("channel");
                switch (channel) {
                    case "Orders":
                        OrderDataResponse orderResponse = JSON.parseObject(message, OrderDataResponse.class);
                        handleOrderData(orderResponse);
                        break;
                    default:
                        logger.info("Unhandled data push: {}", message);
                }
                return;
            }
            
            // Other messages
            logger.info("Other message: {}", message);
        } catch (Exception e) {
            logger.error("Message processing error: {}", e.getMessage());
        }
    }

    protected void handleOrderData(OrderDataResponse response) {
        logger.info("Received order data push: {}", JSON.toJSONString(response));
        // Subclasses can override this method to implement custom handling logic
    }

    @Override
    public void onConnected() {
        logger.info("WebSocket connected");
    }

    @Override
    public void onDisconnected(int code, String reason) {
        logger.info("WebSocket disconnected: {}", reason);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("WebSocket error: {}", throwable.getMessage());
    }
} 