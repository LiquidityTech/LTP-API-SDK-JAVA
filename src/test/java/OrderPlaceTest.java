import rapdix.client.RapdixAPIClient;
import rapdix.model.PageEntity;
import rapdix.model.request.account.AccountPositionModeRequest;
import rapdix.model.request.account.AccountQueryRequest;
import rapdix.model.request.order.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.AccountVO;
import rapdix.model.vo.order.OrderPlaceVO;
import rapdix.model.vo.order.OrderVO;
import rapdix.model.vo.order.OrderReplaceVO;
import rapdix.client.RequestTimingInterceptor;

import java.util.List;

public class OrderPlaceTest {
    private static final String API_KEY = "ABC";
    private static final String SECRET_KEY = "XYZ";

    public static void main(String[] args) {
        OrderPlaceTest orderTest = new OrderPlaceTest();
        orderTest.placeOrder();
        orderTest.replaceOrder();
        orderTest.queryOrderDetail();
        orderTest.currentOrderDetail();
        orderTest.queryAccount();
        orderTest.cancelAll();
        orderTest.changePositionMode();
    }

    public void placeOrder() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);

        client.setRequestTimingListener(new RequestTimingInterceptor.RequestTimingListener() {
            @Override
            public void onRequestStart(String url, long startTimeNanos) {
                long sdkCallTime = System.nanoTime();
                long timeToSendRequest = sdkCallTime - startTimeNanos;

                System.out.println("请求URL: " + url);
                System.out.println(String.format("耗时: %.3f 毫秒", timeToSendRequest / 1_000_000.0));
            }
        });

        OrderPlaceRequest request = OrderPlaceRequest.builder()
                .sym("BINANCE_PERP_BTC_USDT")
                .orderQty("1")
                .limitPrice("110")
                .side("BUY")
                .orderType("LIMIT")
                .build();

        ApiResponse<OrderPlaceVO> response = client.order().placeOrder(request);
        System.out.println("API响应: " + response);
    }

    public void replaceOrder() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);
        OrderReplaceRequest request = OrderReplaceRequest.builder()
                .orderId("1739944122427000")
                .build();
        ApiResponse<OrderReplaceVO> response = client.order().replaceOrder(request);
        System.out.println(response);
    }

    public void queryOrderDetail() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);
        OrderDetailRequest request = OrderDetailRequest.builder()
                .orderId("1739945759364000")
                .build();
        ApiResponse<OrderVO> response = client.order().queryOrderDetail(request);
        System.out.println(response);
    }

    public void currentOrderDetail() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);
        CurrentOpenOrdersRequest request = CurrentOpenOrdersRequest.builder()
                .build();
        ApiResponse<PageEntity<OrderVO>> response = client.order().currentOpenDetail(request);
        System.out.println(response);
    }

    public void queryAccount() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);
        AccountQueryRequest request = AccountQueryRequest.builder()
                .build();
        ApiResponse<List<AccountVO>> response = client.account().queryAccount(request);
        System.out.println(response);
    }

    public void cancelAll() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);
        OrdersCancelRequest request = OrdersCancelRequest.builder()
                .build();
        ApiResponse<Void> response = client.order().cancelOrders(request);
        System.out.println(response);
    }

    public void changePositionMode() {
        RapdixAPIClient client = new RapdixAPIClient(API_KEY, SECRET_KEY);
        AccountPositionModeRequest request = AccountPositionModeRequest.builder()
                .positionMode("BINANCE")
                .exchangeType("BOTH")
                .build();
        ApiResponse<Void> response = client.account().changeAccountPositionMode(request);
        System.out.println(response);
    }

}
