import com.alibaba.fastjson.JSON;
import rapdix.websocket.client.UserWebSocketClient;
import rapdix.websocket.listener.WebSocketMessageListener;
import rapdix.websocket.model.request.PlaceOrderRequest;
import rapdix.websocket.model.request.CancelOrderRequest;
import rapdix.websocket.model.request.CancelOrdersRequest;
import rapdix.websocket.model.response.OrderDataResponse;
import rapdix.websocket.listener.DefaultWebSocketMessageListener;

public class UserWebSocketTest {
    private static final String API_KEY = "ABC";
    private static final String SECRET_KEY = "XYZ";

    public static void main(String[] args) throws InterruptedException {
        UserWebSocketTest userWebSocketTest = new UserWebSocketTest();
        userWebSocketTest.testUserWebSocketLogin();
        userWebSocketTest.testPlaceOrder();
        userWebSocketTest.testCancelOrder();
        userWebSocketTest.testCancelOrders();
    }

    public void testUserWebSocketLogin() throws InterruptedException {
        UserWebSocketClient client = new UserWebSocketClient(API_KEY, SECRET_KEY);

        // Set message listener
        client.setMessageListener(new WebSocketMessageListener() {
            @Override
            public void onMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void onConnected() {
                System.out.println("Connected");
            }

            @Override
            public void onDisconnected(int code, String reason) {
                System.out.println("Disconnected: " + reason);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        try {
            client.connect();
            Thread.sleep(5000);
        } finally {
            client.disconnect();
        }
    }


    public void testUserWebSocketWithDefaultListener() throws InterruptedException {
        UserWebSocketClient client = new UserWebSocketClient(API_KEY, SECRET_KEY);

        try {
            client.connect();
            Thread.sleep(5000);
        } finally {
            client.disconnect();
        }
    }

    public void testPlaceOrder() throws InterruptedException {
        UserWebSocketClient client = new UserWebSocketClient(API_KEY, SECRET_KEY);
        client.setMessageListener(new WebSocketMessageListener() {
            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
            }

            @Override
            public void onConnected() {
                System.out.println("Connected");
            }

            @Override
            public void onDisconnected(int code, String reason) {
                System.out.println("Disconnected: " + reason);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        try {
            client.connect();
            Thread.sleep(2000);
            PlaceOrderRequest.OrderArgs limitOrderArgs = PlaceOrderRequest.OrderArgs.builder() // 可选参数
                    .sym("BINANCE_PERP_BTC_USDT")
                    .side("BUY")
                    .orderType("LIMIT")
                    .orderQty("0.01")
                    .limitPrice("30000")
                    .timeInForce("GTC")
                    .build();

            PlaceOrderRequest limitOrderRequest = PlaceOrderRequest.builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .args(limitOrderArgs)
                    .build();
            System.out.println(JSON.toJSONString(limitOrderRequest));
            client.placeOrder(limitOrderRequest);
            Thread.sleep(2000);

            PlaceOrderRequest.OrderArgs marketOrderArgs = PlaceOrderRequest.OrderArgs.builder()
                    .sym("BINANCE_PERP_BTC_USDT")
                    .side("BUY")
                    .orderType("MARKET")
                    .quoteOrderQty("30")
                    .build();

            PlaceOrderRequest marketOrderRequest = PlaceOrderRequest.builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .args(marketOrderArgs)
                    .build();

            client.placeOrder(marketOrderRequest);
            Thread.sleep(2000);

            PlaceOrderRequest.OrderArgs tpslOrderArgs = PlaceOrderRequest.OrderArgs.builder()
                    .sym("BINANCE_PERP_BTC_USDT")
                    .side("BUY")
                    .orderType("LIMIT")
                    .orderQty("0.01")
                    .limitPrice("30000")
                    .timeInForce("GTC")
                    .tpTriggerPrice("32000")
                    .tpPrice("31900")
                    .slTriggerPrice("29000")
                    .slPrice("28900")
                    .build();

            PlaceOrderRequest tpslOrderRequest = PlaceOrderRequest.builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .args(tpslOrderArgs)
                    .build();

            client.placeOrder(tpslOrderRequest);
            Thread.sleep(2000);

        } finally {
            client.disconnect();
        }
    }

    public void testCancelOrder() throws InterruptedException {
        UserWebSocketClient client = new UserWebSocketClient(API_KEY, SECRET_KEY);

        client.setMessageListener(new WebSocketMessageListener() {
            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
            }

            @Override
            public void onConnected() {
                System.out.println("Connected");
            }

            @Override
            public void onDisconnected(int code, String reason) {
                System.out.println("Disconnected: " + reason);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        try {
            client.connect();
            Thread.sleep(2000);

            CancelOrderRequest.CancelOrderArgs cancelByOrderIdArgs = CancelOrderRequest.CancelOrderArgs.builder()
                    .orderId("2008495901661251")
                    .build();

            CancelOrderRequest cancelByOrderIdRequest = CancelOrderRequest.builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .args(cancelByOrderIdArgs)
                    .build();

            client.cancelOrder(cancelByOrderIdRequest);
            Thread.sleep(2000);

            CancelOrderRequest.CancelOrderArgs cancelByClientOrderIdArgs = CancelOrderRequest.CancelOrderArgs.builder()
                    .clientOrderId("2008495901661251")
                    .build();

            CancelOrderRequest cancelByClientOrderIdRequest = CancelOrderRequest.builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .args(cancelByClientOrderIdArgs)
                    .build();

            client.cancelOrder(cancelByClientOrderIdRequest);
            Thread.sleep(2000);

        } finally {
            client.disconnect();
        }
    }

    public void testCancelOrders() throws InterruptedException {
        UserWebSocketClient client = new UserWebSocketClient(API_KEY, SECRET_KEY);

        client.setMessageListener(new WebSocketMessageListener() {
            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
            }

            @Override
            public void onConnected() {
                System.out.println("Connected");
            }

            @Override
            public void onDisconnected(int code, String reason) {
                System.out.println("Disconnected: " + reason);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        try {
            client.connect();
            Thread.sleep(2000);

            CancelOrdersRequest.CancelOrdersArgs args1 = CancelOrdersRequest.CancelOrdersArgs.builder()
                    .build();

            CancelOrdersRequest request1 = CancelOrdersRequest.builder()
                    .id(String.valueOf(System.currentTimeMillis()))
                    .args(args1)
                    .build();

            client.cancelOrders(request1);
            Thread.sleep(2000);

            client.cancelOrders("BINANCE");
            Thread.sleep(2000);

        } finally {
            client.disconnect();
        }
    }

    public void testUserDataStream() throws InterruptedException {
        UserWebSocketClient client = new UserWebSocketClient(API_KEY, SECRET_KEY);

        client.setMessageListener(new DefaultWebSocketMessageListener() {
            @Override
            protected void handleOrderData(OrderDataResponse response) {
                System.out.println("Received order data:");
                System.out.println("- Exchange: " + response.getData().getExchangeType());
                System.out.println("- Order ID: " + response.getData().getOrderId());
                System.out.println("- Symbol: " + response.getData().getSym());
                System.out.println("- Order State: " + response.getData().getOrderState());
                System.out.println("- Executed Quantity: " + response.getData().getExecutedQty());
                System.out.println("- Average Price: " + response.getData().getExecutedAvgPrice());
            }

            @Override
            public void onMessage(String message) {
                System.out.println("Raw message: " + message);
            }
        });

        try {
            client.connect();
            Thread.sleep(30000);
        } finally {
            client.disconnect();
        }
    }
} 