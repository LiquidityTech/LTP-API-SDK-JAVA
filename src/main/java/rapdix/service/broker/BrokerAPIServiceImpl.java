package rapdix.service.broker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.request.broker.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.broker.ClearingStatementVO;
import rapdix.model.vo.broker.CollectionRecordVO;
import rapdix.model.vo.broker.SubPortfolioFeeRateVO;
import rapdix.model.vo.broker.UserFeeVo;
import rapdix.model.vo.rules.PositionTierVO;

import java.util.List;
import java.util.Map;

public class BrokerAPIServiceImpl implements BrokerAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;
    public BrokerAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Get Broker Position Tier
     *
     * @param request UserInterestRequest request
     * @return ApiResponse<Map<String, List<PositionTierVO>>>
     */
    @Override
    public ApiResponse<Map<String, List<PositionTierVO>>> getBrokerPositionTier(BrokerPositionTierRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.BROKER_POSITION_TIER,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Map<String, List<PositionTierVO>>>>() {
        });
    }

    /**
     * Set Sub Portfolio Fee Rate
     *
     * @param request SubPortfolioFeeRateRequest request
     * @return ApiResponse<SubPortfolioFeeRateVO>
     */
    @Override
    public ApiResponse<SubPortfolioFeeRateVO> setSubPortfolioFeeRate(SubPortfolioFeeRateRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doPost(urlBase + RapidxAPIConstants.SUB_PORTFOLIO_FEE_RATE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<SubPortfolioFeeRateVO>>() {
        });
    }

    /**
     * Get Fee Rate
     *
     * @param request FeeRateRequest request
     * @return ApiResponse<List<UserFeeVo>>
     */
    @Override
    public ApiResponse<List<UserFeeVo>> getFeeRate(FeeRateRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.BROKER_FEE_RATE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<UserFeeVo>>>() {
        });
    }

    /**
     * Get Fee Rate For Sub Portfolio
     *
     * @param request SubFeeRateRequest request
     * @return ApiResponse<List<UserFeeVo>>
     */
    @Override
    public ApiResponse<List<UserFeeVo>> getSubPortfolioFeeRate(SubFeeRateRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.BROKER_SUB_FEE_RATE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<UserFeeVo>>>() {
        });
    }

    /**
     * Get Clearing Statement
     *
     * @param request ClearingStatementRequest request
     * @return ApiResponse<ClearingStatementVO>
     */
    @Override
    public ApiResponse<ClearingStatementVO> getClearingStatement(ClearingStatementRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.CLEARING_STATEMENT,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<ClearingStatementVO>>() {
        });
    }

    /**
     * Get Collection Record
     *
     * @param request CollectionRecordRequest request
     * @return ApiResponse<CollectionRecordVO>
     */
    @Override
    public ApiResponse<CollectionRecordVO> getCollectionRecord(CollectionRecordRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.COLLECTION_RECORD,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<CollectionRecordVO>>() {
        });
    }
}
