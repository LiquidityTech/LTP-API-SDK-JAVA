
import rapdix.websocket.client.PublicWebSocketClient;
import rapdix.websocket.listener.WebSocketMessageListener;

public class WebSocketTest {
    public static void main(String[] args) throws InterruptedException {
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.testPublicWebSocket();
        webSocketTest.testBBOSubscribe();
        webSocketTest.testPublicWebSocketWithDefaultListener();
        webSocketTest.testMultipleSubscriptions();
        webSocketTest.testOrderBookSubscribe();
        webSocketTest.testAllMarketDataSubscriptions();
    }

    public void testPublicWebSocket() throws InterruptedException {

        PublicWebSocketClient client = new PublicWebSocketClient();

        client.setMessageListener(new WebSocketMessageListener() {
            @Override
            public void onMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void onConnected() {
                System.out.println("connected");
            }

            @Override
            public void onDisconnected(int code, String reason) {
                System.out.println("disconnected: " + reason);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error: " + throwable.getMessage());
            }
        });

        try {
            client.subscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            Thread.sleep(20000);
            client.unsubscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            Thread.sleep(2000);
        } finally {
            client.disconnect();
        }
    }


    public void testPublicWebSocketWithDefaultListener() throws InterruptedException {
        PublicWebSocketClient client = new PublicWebSocketClient();

        try {
            client.subscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            Thread.sleep(20000);
            client.unsubscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            client.unsubscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            Thread.sleep(2000);
        } finally {
            client.disconnect();
        }
    }


    public void testBBOSubscribe() throws InterruptedException {
        PublicWebSocketClient client = new PublicWebSocketClient();
        try {
            client.subscribeBBO("BINANCE_PERP_BTC_USDT");
            Thread.sleep(20000);
            client.unsubscribeBBO("BINANCE_PERP_BTC_USDT");
            Thread.sleep(2000);
        } finally {
            client.disconnect();
        }
    }


    public void testMultipleSubscriptions() throws InterruptedException {
        PublicWebSocketClient client = new PublicWebSocketClient();

        try {
            client.subscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            client.subscribeBBO("BINANCE_PERP_BTC_USDT");
            Thread.sleep(20000);
            client.unsubscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            client.unsubscribeBBO("BINANCE_PERP_BTC_USDT");
            Thread.sleep(2000);
        } finally {
            client.disconnect();
        }
    }


    public void testOrderBookSubscribe() throws InterruptedException {
        PublicWebSocketClient client = new PublicWebSocketClient();

        try {
            client.subscribeOrderBook(
                    "BINANCE_PERP_BTC_USDT"
            );
            // client.subscribeOrderBook(
            //     "BINANCE_PERP_BTC_USDT",
            //     "OKX_PERP_BTC_USDT",
            //     "BINANCE_SPOT_BTC_USDT",
            //     "OKX_SPOT_BTC_USDT"
            // );
            Thread.sleep(20000);
            client.unsubscribeOrderBook(
                    "BINANCE_PERP_BTC_USDT"
            );
            // client.unsubscribeOrderBook(
            //     "BINANCE_PERP_BTC_USDT",
            //     "OKX_PERP_BTC_USDT",
            //     "BINANCE_SPOT_BTC_USDT",
            //     "OKX_SPOT_BTC_USDT"
            // );
            Thread.sleep(2000);
        } finally {
            client.disconnect();
        }
    }


    public void testAllMarketDataSubscriptions() throws InterruptedException {
        PublicWebSocketClient client = new PublicWebSocketClient();

        try {
            client.subscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            client.subscribeBBO("BINANCE_PERP_BTC_USDT");
            client.subscribeOrderBook(
                    "BINANCE_PERP_BTC_USDT",
                    "OKX_PERP_BTC_USDT"
            );

            Thread.sleep(30000);

            client.unsubscribeMarkPrice("BINANCE_PERP_BTC_USDT");
            client.unsubscribeBBO("BINANCE_PERP_BTC_USDT");
            client.unsubscribeOrderBook(
                    "BINANCE_PERP_BTC_USDT",
                    "OKX_PERP_BTC_USDT"
            );
            Thread.sleep(2000);
        } finally {
            client.disconnect();
        }
    }
} 