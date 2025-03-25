package rapdix.service.rules;

import rapdix.model.PageEntity;
import rapdix.model.request.rules.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.rules.*;

import java.util.List;
import java.util.Map;

public interface TradingRulesAPIService {
    ApiResponse<Void> setMarginLeverage(MarginLeverageSetRequest request);
    ApiResponse<PageEntity<MarginLeverageVO>> getMarginLeverage(MarginLeverageGetRequest request);
    ApiResponse<Map<String, SymbolInfoVO>> symInfo(SymInfoReuqest request);
    ApiResponse<FundingRateVO> getCurrentFundingRate(FundingRateRequest request);
    ApiResponse<MarkPriceVO> getCurrentMarkPrice(MarkPriceRequest request);
    ApiResponse<List<UserFeeRateVO>> userTradingFeeRate(UserTradingFeeRateRequest request);
    ApiResponse<Map<String, List<PositionTierVO>>> getPositionTier(PositionTierRequest request);
    ApiResponse<List<LoanTierVO>> getLoanTier(LoanTierRequest request);
    ApiResponse<List<CoinDiscountVO>> getDiscountRate(DiscountRateRequest request);
    ApiResponse<Map<String, List<UserInterestVO>>> getUserInterest(UserInterestRequest request);
}
