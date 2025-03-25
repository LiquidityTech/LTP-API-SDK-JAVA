package rapdix.service.order;

import rapdix.model.PageEntity;
import rapdix.model.request.order.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.order.*;
import rapdix.model.vo.order.OrderVO;

public interface OrderAPIService {
    ApiResponse<OrderPlaceVO> placeOrder(OrderPlaceRequest request);
    ApiResponse<OrderReplaceVO> replaceOrder(OrderReplaceRequest request);
    ApiResponse<OrderCancelVO> cancelOrder(OrderCancelRequest request);
    ApiResponse<Void> cancelOrders(OrdersCancelRequest request);
    ApiResponse<OrderVO> queryOrderDetail(OrderDetailRequest request);
    ApiResponse<PageEntity<OrderVO>> currentOpenDetail(CurrentOpenOrdersRequest request);
    ApiResponse<PageEntity<OrderVO>> orderHistory(OrderHistoryRequest request);
    ApiResponse<PageEntity<OrderVO>> orderHistoryArchive(OrderHistoryRequest request);
}
