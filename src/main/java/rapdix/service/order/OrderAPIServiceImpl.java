package rapdix.service.order;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.PageEntity;
import rapdix.model.request.order.*;
import rapdix.model.response.ApiResponse;
import com.alibaba.fastjson.JSON;
import rapdix.model.vo.order.*;
import rapdix.model.vo.order.OrderVO;

public class OrderAPIServiceImpl implements OrderAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;

    public OrderAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Places an order using the provided order request details.
     * <p>
     * Place a new order, this api is asynchronous. Returning success only means that the request is successful.
     * The final result needs to be confirmed through websocket subscription and order query.
     * </p>
     *
     * @param request <b>Mandatory fields:</b> sym, side, orderType.
     * @return ApiResponse<OrderVO>
     */
    public ApiResponse<OrderPlaceVO> placeOrder(OrderPlaceRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doPost(urlBase + RapidxAPIConstants.ORDER, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<OrderPlaceVO>>() {
        });
    }

    /**
     * Replaces an order using the provided order request details.
     * <p>
     * Replace order, support orderQty and limitPrice.
     * Please note that currently replace spot order and a small part of situation with perp order are achieved through a rapid cancel and place a new order process.
     * </p>
     *
     * @param request <b>Mandatory fields:</b> orderId.
     * @return ApiResponse<OrderReplaceVO>
     */
    public ApiResponse<OrderReplaceVO> replaceOrder(OrderReplaceRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doPut(urlBase + RapidxAPIConstants.ORDER, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<OrderReplaceVO>>() {
        });
    }

    /**
     * Cancels an order using the provided order request details.
     * <p>
     * Cancel an incomplete order, this api is asynchronous.
     * Returning success only means that the request is successful.
     * The final result needs to be confirmed through websocket subscription and order query.
     * </p>
     *
     * @param request Either orderId or clientOrderId must be sent. If both orderId and clientOrderId are provided, orderId takes precedence
     * @return ApiResponse<OrderCancelVO>
     */
    public ApiResponse<OrderCancelVO> cancelOrder(OrderCancelRequest request) {
        String body;
        String jsonRequest = JSON.toJSONString(request);
        body = this.httpClient.getInstance().doDelete(urlBase + RapidxAPIConstants.ORDER, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<OrderCancelVO>>() {
        }, Feature.IgnoreNotMatch);
    }

    /**
     * Cancels All orders using the provided order request details.
     * <p>
     * Cancel all open orders, if you provide a portfolioId, cancel all open orders under that portfolio.
     * If you don't provide one, cancel all open orders for the user across all portfolios.
     * </p>
     *
     * @param request exchangeType, sym
     * @return ApiResponse<Void>
     */
    @Override
    public ApiResponse<Void> cancelOrders(OrdersCancelRequest request) {
        String body;
        String jsonRequest = JSON.toJSONString(request);
        body = this.httpClient.getInstance().doDelete(urlBase + RapidxAPIConstants.ORDER_CANCEL_ALL, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Void>>() {
        });
    }

    /**
     * Retrieve order details for all order status.
     *
     * @param request Either orderId or clientOrderId must be sent.
     *                query all order state (NEW, OPEN, CANCELLED, FILLED, PARTIALLY_FILLED, REJECT, FAIL)
     * @return ApiResponse<OrderDetailVO>
     */
    public ApiResponse<OrderVO> queryOrderDetail(OrderDetailRequest request) {
        String body;
        String jsonRequest = JSON.toJSONString(request);
        body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ORDER, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<OrderVO>>() {
        });
    }

    /**
     * Retrieve order details for all NEW/OPEN/PARTIALLY_FILLED status.
     *
     * @param request <b>Mandatory fields:</b> orderId.
     * @return ApiResponse<PageEntity<OrderVO>>
     */
    @Override
    public ApiResponse<PageEntity<OrderVO>> currentOpenDetail(CurrentOpenOrdersRequest request) {
        String body;
        String jsonRequest = JSON.toJSONString(request);
        body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ORDERS, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<OrderVO>>>() {
        });
    }

    /**
     * Retrieve finished orders from the past 7 days.
     *
     * @param request sym, businessType, exchange, begin, end, page, pageSize
     * @return ApiResponse<PageEntity<OrderVO>>
     */
    @Override
    public ApiResponse<PageEntity<OrderVO>> orderHistory(OrderHistoryRequest request) {
        String body;
        String jsonRequest = JSON.toJSONString(request);
        body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ORDER_HISTORY, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<OrderVO>>>() {
        });
    }

    /**
     * Retrieve finished orders from the past 7 to 90 days.
     *
     * @param request sym, businessType, exchange, begin, end, page, pageSize
     * @return ApiResponse<PageEntity<OrderVO>>
     */
    @Override
    public ApiResponse<PageEntity<OrderVO>> orderHistoryArchive(OrderHistoryRequest request) {
        String body;
        String jsonRequest = JSON.toJSONString(request);
        body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ORDER_HISTORY_ARCHIVE, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<OrderVO>>>() {
        });
    }

}
