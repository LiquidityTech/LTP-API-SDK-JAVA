package rapdix.service.position;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.PageEntity;
import rapdix.model.request.position.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.position.*;

import java.util.List;

public class PositionAPIServiceImpl implements PositionAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;

    public PositionAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Set leverage， this api is asynchronous. Returning success only means that the request is successful.
     * The final result needs to be confirmed through websocket subscription and order query.
     *
     * @param request LeverageSetRequest request
     * @return ApiResponse<Void>
     */
    @Override
    public ApiResponse<Void> setLeverage(LeverageSetRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doPost(urlBase + RapidxAPIConstants.LEVERAGE_SET, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Void>>() {
        });
    }

    /**
     * Get leverage.
     *
     * @param request LeverageGetRequest request
     * @return ApiResponse<List<LeverageVO>>
     */
    @Override
    public ApiResponse<List<LeverageVO>> getLeverage(LeverageGetRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.LEVERAGE_GET, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<LeverageVO>>>() {
        });
    }

    /**
     * Close position， this api is asynchronous. Returning success only means that the request is successful.
     * The final result needs to be confirmed through websocket subscription and order query.
     *
     * @param request PositionCloseRequest request
     * @return ApiResponse<List<AssetVO>>
     */
    @Override
    public ApiResponse<List<PositionVO>> closePosition(PositionCloseRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doDelete(urlBase + RapidxAPIConstants.POSITION, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<PositionVO>>>() {
        });
    }

    /**
     * Close position batch, this api is asynchronous. Returning success only means that the request is successful.
     * The final result needs to be confirmed through websocket subscription and order query
     *
     * @param request PositionsCloseRequest request
     * @return ApiResponse<List<PositionsVO>>
     */
    @Override
    public ApiResponse<List<PositionsVO>> closePositions(PositionsCloseRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doDelete(urlBase + RapidxAPIConstants.POSITIONS, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<PositionsVO>>>() {
        });
    }

    /**
     * Query Portfolio Position
     *
     * @param request PositionPortfolioRequest request
     * @return ApiResponse<List<PortfolioPosition>>
     */
    @Override
    public ApiResponse<List<PositionPortfolioVO>> queryPortfolioPosition(PositionPortfolioRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.POSITION, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<PositionPortfolioVO>>>() {
        });
    }

    /**
     * Query Portfolio History Position
     *
     * @param request PositionPortfolioHistoryRequest request
     * @return ApiResponse<PageEntity<PositionHistoryVO>>
     */
    @Override
    public ApiResponse<PageEntity<PositionHistoryVO>> queryPortfolioHistoryPosition(PositionPortfolioHistoryRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.POSITIONS_HISTORY, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<PositionHistoryVO>>>() {
        });
    }
}
