package rapdix.service.statement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.PageEntity;
import rapdix.model.request.statement.StatementRequest;
import rapdix.model.request.statement.UserTradingStatsRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.statement.AssetStatementVO;
import rapdix.model.vo.statement.UserTradingStatsVO;

public class StatementAPIServiceImpl implements StatementAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;

    public StatementAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Query Statement
     *
     * @param request StatementRequest request
     * @return ApiResponse<PageEntity < AssetStatementVO>>
     */
    @Override
    public ApiResponse<PageEntity<AssetStatementVO>> queryStatement(StatementRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.STATEMENT, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<AssetStatementVO>>>() {
        });
    }

    /**
     * Query User TradingStats
     *
     * @param request UserTradingStatsRequest request
     * @return ApiResponse<UserTradingStatsDTO>
     */
    @Override
    public ApiResponse<UserTradingStatsVO> queryUserTradingStats(UserTradingStatsRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.USER_TRADING_STATS, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<UserTradingStatsVO>>() {
        });
    }

}
