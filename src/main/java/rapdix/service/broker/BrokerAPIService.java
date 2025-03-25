package rapdix.service.broker;

import rapdix.model.request.broker.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.broker.ClearingStatementVO;
import rapdix.model.vo.broker.CollectionRecordVO;
import rapdix.model.vo.broker.SubPortfolioFeeRateVO;
import rapdix.model.vo.broker.UserFeeVo;
import rapdix.model.vo.rules.PositionTierVO;

import java.util.List;
import java.util.Map;

public interface BrokerAPIService {
    ApiResponse<Map<String, List<PositionTierVO>>> getBrokerPositionTier(BrokerPositionTierRequest request);
    ApiResponse<SubPortfolioFeeRateVO> setSubPortfolioFeeRate(SubPortfolioFeeRateRequest request);
    ApiResponse<List<UserFeeVo>> getFeeRate(FeeRateRequest request);
    ApiResponse<List<UserFeeVo>> getSubPortfolioFeeRate(SubFeeRateRequest request);
    ApiResponse<ClearingStatementVO> getClearingStatement(ClearingStatementRequest request);
    ApiResponse<CollectionRecordVO> getCollectionRecord(CollectionRecordRequest request);
}
