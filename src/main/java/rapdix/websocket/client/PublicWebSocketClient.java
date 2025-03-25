package rapdix.websocket.client;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rapdix.websocket.listener.DefaultWebSocketMessageListener;
import rapdix.websocket.listener.WebSocketMessageListener;
import rapdix.websocket.model.request.MarkPriceSubscribeRequest;
import rapdix.websocket.model.request.BBOSubscribeRequest;
import rapdix.websocket.model.request.OrderBookSubscribeRequest;

import javax.websocket.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.zip.GZIPInputStream;

@ClientEndpoint
public class PublicWebSocketClient implements BaseWebSocketClient {
    private static final Logger logger = LoggerFactory.getLogger(PublicWebSocketClient.class);
    private static final String WS_URL = "wss://mds.liquiditytech.com/v2/public";

    private Session session;
    private WebSocketMessageListener messageListener;
    private CountDownLatch connectionLatch;
    private volatile boolean isConnected;

    public PublicWebSocketClient() {
        this.messageListener = new DefaultWebSocketMessageListener();
        this.connectionLatch = new CountDownLatch(1);
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        this.isConnected = true;
        messageListener.onConnected();
        connectionLatch.countDown();
    }

    @OnMessage
    public void onBinaryMessage(byte[] message) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(message);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzip.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
            gzip.close();
            bos.close();

            String msg = new String(bos.toByteArray(), java.nio.charset.StandardCharsets.UTF_8);
            messageListener.onMessage(msg);
        } catch (Exception e) {
            logger.error("websocket message error", e);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        this.isConnected = false;
        messageListener.onDisconnected(closeReason.getCloseCode().getCode(), closeReason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        messageListener.onError(throwable);
    }

    @Override
    public void connect() {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(WS_URL));
            connectionLatch.await();
        } catch (Exception e) {
            logger.error("WebSocket connect error", e);
            throw new RuntimeException("WebSocket connect error", e);
        }
    }

    @Override
    public void disconnect() {
        if (session != null) {
            try {
                session.close();
            } catch (Exception e) {
                logger.error("websocket disconnect error", e);
            }
        }
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public void setMessageListener(WebSocketMessageListener listener) {
        this.messageListener = listener != null ? listener : new DefaultWebSocketMessageListener();
    }

    @Override
    public void send(String message) {
        if (session != null && isConnected) {
            session.getAsyncRemote().sendText(message);
        }
    }

    public void subscribeMarkPrice(String instId) {
        if (!isConnected) {
            connect();
        }

        MarkPriceSubscribeRequest.SubscribeArg arg = MarkPriceSubscribeRequest.SubscribeArg.builder()
                .channel("MARK_PRICE")
                .instId(instId)
                .build();

        MarkPriceSubscribeRequest request = MarkPriceSubscribeRequest.builder()
                .event("SUBSCRIBE")
                .arg(Collections.singletonList(arg))
                .build();

        String requestStr = JSON.toJSONString(request);
        send(requestStr);
    }

    public void unsubscribeMarkPrice(String instId) {
        if (!isConnected) {
            return;
        }

        MarkPriceSubscribeRequest.SubscribeArg arg = MarkPriceSubscribeRequest.SubscribeArg.builder()
                .channel("MARK_PRICE")
                .instId(instId)
                .build();

        MarkPriceSubscribeRequest request = MarkPriceSubscribeRequest.builder()
                .event("UNSUBSCRIBE")
                .arg(Collections.singletonList(arg))
                .build();

        String requestStr = JSON.toJSONString(request);
        send(requestStr);
    }

    public void subscribeBBO(String instId) {
        if (!isConnected) {
            connect();
        }

        BBOSubscribeRequest.SubscribeArg arg = BBOSubscribeRequest.SubscribeArg.builder()
                .channel("BBO")
                .instId(instId)
                .build();

        BBOSubscribeRequest request = BBOSubscribeRequest.builder()
                .event("SUBSCRIBE")
                .arg(Collections.singletonList(arg))
                .build();

        String requestStr = JSON.toJSONString(request);
        send(requestStr);
    }

    public void unsubscribeBBO(String instId) {
        if (!isConnected) {
            return;
        }

        BBOSubscribeRequest.SubscribeArg arg = BBOSubscribeRequest.SubscribeArg.builder()
                .channel("BBO")
                .instId(instId)
                .build();

        BBOSubscribeRequest request = BBOSubscribeRequest.builder()
                .event("UNSUBSCRIBE")
                .arg(Collections.singletonList(arg))
                .build();

        String requestStr = JSON.toJSONString(request);
        send(requestStr);
    }

    public void subscribeOrderBook(String... instIds) {
        if (!isConnected) {
            connect();
        }

        List<OrderBookSubscribeRequest.SubscribeArg> args = Arrays.stream(instIds)
                .map(instId -> OrderBookSubscribeRequest.SubscribeArg.builder()
                        .channel("ORDER_BOOK")
                        .instId(instId)
                        .build())
                .collect(java.util.stream.Collectors.toList());

        OrderBookSubscribeRequest request = OrderBookSubscribeRequest.builder()
                .event("SUBSCRIBE")
                .arg(args)
                .build();

        String requestStr = JSON.toJSONString(request);
        send(requestStr);
    }

    public void unsubscribeOrderBook(String... instIds) {
        if (!isConnected) {
            return;
        }

        List<OrderBookSubscribeRequest.SubscribeArg> args = Arrays.stream(instIds)
                .map(instId -> OrderBookSubscribeRequest.SubscribeArg.builder()
                        .channel("ORDER_BOOK")
                        .instId(instId)
                        .build())
                .collect(java.util.stream.Collectors.toList());

        OrderBookSubscribeRequest request = OrderBookSubscribeRequest.builder()
                .event("UNSUBSCRIBE")
                .arg(args)
                .build();

        String requestStr = JSON.toJSONString(request);
        send(requestStr);
    }
} 