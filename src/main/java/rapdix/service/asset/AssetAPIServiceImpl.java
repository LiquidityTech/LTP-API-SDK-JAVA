package rapdix.service.asset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.PageEntity;
import rapdix.model.request.asset.PortfolioDetailRequest;
import rapdix.model.request.asset.PortfolioFundsHistoryRequest;
import rapdix.model.request.asset.UserAllPortfolioRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.asset.AssetVO;
import rapdix.model.vo.asset.AssetPortfolioHistoryVO;

import java.util.List;
import java.util.Map;

public class AssetAPIServiceImpl implements AssetAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;

    public AssetAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Change PositionMode must don't have orders/positions,
     * Please note that this API only applies to sub-portfolio's API Key so far and can't apply to primary-user's API Key yet.
     * For checking the deposit/transfer/withdrawal history of primary-user and main portfolio, please use deposit/transfer/withdrawal history API.
     *
     * @param request PortfolioFundsHistoryRequest request
     * @return ApiResponse<AssetPortfolioHistoryVO>
     */
    @Override
    public ApiResponse<AssetPortfolioHistoryVO> portfolioFundsHistory(PortfolioFundsHistoryRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ASSET_PORTFOLIO_FUNDS_HISTORY, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<AssetPortfolioHistoryVO>>() {
        });
    }

    /**
     * Get portfolio asset by portfolioId.
     *
     * @param request exchangeType, pageNum, pageSize
     * @return ApiResponse<PageEntity<AssetVO>>
     */
    @Override
    public ApiResponse<PageEntity<AssetVO>> portfolioDetail(PortfolioDetailRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ASSET_PORTFOLIO_DETAIL, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<AssetVO>>>() {
        });
    }

    /**
     * Get current user all asset.
     *
     * @param request UserAllPortfolioRequest(None)
     * @return ApiResponse<Map<String,List<AssetVO>>>
     */
    @Override
    public ApiResponse<Map<String,List<AssetVO>>> UserAllPortfolio(UserAllPortfolioRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.ASSET_ALL_PORTFOLIO, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Map<String,List<AssetVO>>>>() {
        });
    }
}
