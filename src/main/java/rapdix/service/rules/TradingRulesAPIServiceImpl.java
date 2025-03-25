package rapdix.service.rules;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.PageEntity;
import rapdix.model.request.rules.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.rules.*;

import java.util.List;
import java.util.Map;

public class TradingRulesAPIServiceImpl implements TradingRulesAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;
    public TradingRulesAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Set Margin Leverage
     *
     * @param request MarginLeverageSetRequest request
     * @return ApiResponse<Void>
     */
    @Override
    public ApiResponse<Void> setMarginLeverage(MarginLeverageSetRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doPost(urlBase + RapidxAPIConstants.MARGIN_LEVERAGE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Void>>() {
        });
    }

    /**
     * Get Margin Leverage
     *
     * @param request MarginLeverageGetRequest request
     * @return ApiResponse<PageEntity<MarginLeverageVO>>
     */
    @Override
    public ApiResponse<PageEntity<MarginLeverageVO>> getMarginLeverage(MarginLeverageGetRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.MARGIN_LEVERAGE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<MarginLeverageVO>>>() {
        });
    }

    /**
     * Sym Info
     * This endpoint requires authentication.
     *
     * @param request SymInfoReuqest request
     * @return ApiResponse<Map<String, SymbolInfoVO>>
     */
    @Override
    public ApiResponse<Map<String, SymbolInfoVO>> symInfo(SymInfoReuqest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.SYM_INFO,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Map<String, SymbolInfoVO>>>() {
        });
    }

    /**
     * Get Current Funding Rate
     *
     * @param request FundingRateRequest request
     * @return ApiResponse<FundingRateVO>
     */
    @Override
    public ApiResponse<FundingRateVO> getCurrentFundingRate(FundingRateRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.FUNDING_RATE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<FundingRateVO>>() {
        });
    }

    /**
     * Get Current Mark Price
     *
     * @param request MarkPriceRequest request
     * @return ApiResponse<MarkPriceVO>
     */
    @Override
    public ApiResponse<MarkPriceVO> getCurrentMarkPrice(MarkPriceRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.MARK_PRICE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<MarkPriceVO>>() {
        });
    }

    /**
     * User Trading Fee Rate
     *
     * @param request UserTradingFeeRateRequest request
     * @return ApiResponse<List<UserFeeRateVO>>
     */
    @Override
    public ApiResponse<List<UserFeeRateVO>> userTradingFeeRate(UserTradingFeeRateRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.USER_FEE_RATE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<UserFeeRateVO>>>() {
        });
    }

    /**
     * Get Position Tier
     *
     * @param request PositionTierRequest request
     * @return ApiResponse<Map<String, List<PositionTierVO>>
     */
    @Override
    public ApiResponse<Map<String, List<PositionTierVO>>> getPositionTier(PositionTierRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.POSITION_TIER,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Map<String, List<PositionTierVO>>>>() {
        });
    }

    /**
     * Get Loan Tier
     *
     * @param request LoanTierRequest request
     * @return ApiResponse<List<LoanTierVO>>
     */
    @Override
    public ApiResponse<List<LoanTierVO>> getLoanTier(LoanTierRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.LOAN_TIER,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<LoanTierVO>>>() {
        });
    }

    /**
     * Get Discount Rate
     * Retrieve position tiers information
     *
     * @param request DiscountRateRequest request
     * @return ApiResponse<List<CoinDiscountVO>>
     */
    @Override
    public ApiResponse<List<CoinDiscountVO>> getDiscountRate(DiscountRateRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.DISCOUNT_RATE,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<CoinDiscountVO>>>() {
        });
    }

    /**
     * Get User Interest
     *
     * @param request UserInterestRequest request
     * @return ApiResponse<Map<String, List<UserInterestVO>>>
     */
    @Override
    public ApiResponse<Map<String, List<UserInterestVO>>> getUserInterest(UserInterestRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.USER_INTEREST,jsonRequest,apiKey,secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<Map<String, List<UserInterestVO>>>>() {
        });
    }
}
