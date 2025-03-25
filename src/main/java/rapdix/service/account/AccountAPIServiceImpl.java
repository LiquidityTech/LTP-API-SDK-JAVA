package rapdix.service.account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.request.account.AccountPositionModeRequest;
import rapdix.model.request.account.AccountQueryRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.AccountVO;

import java.util.List;

public class AccountAPIServiceImpl implements AccountAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;

    public AccountAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Retrieve account detail in portfolio level
     *
     * @return ApiResponse<AccountVO>
     */
    @Override
    public ApiResponse<List<AccountVO>> queryAccount(AccountQueryRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ACCOUNT, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<AccountVO>>>() {
        });
    }

    /**
     * Change PositionMode must don't have orders/positions,
     * so you should cancel all your orders and close all your positions.
     *
     * @param request NET means single way, also means buy and sale mode, BOTH means hedge way, also means both mode
     * @return ApiResponse<Void>
     */
    @Override
    public ApiResponse<Void> changeAccountPositionMode(AccountPositionModeRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doPost(urlBase + RapidxAPIConstants.ACCOUNT, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Void>>() {
        });
    }
}
