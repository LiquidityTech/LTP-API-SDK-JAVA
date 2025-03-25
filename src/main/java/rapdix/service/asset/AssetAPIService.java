package rapdix.service.asset;

import rapdix.model.PageEntity;
import rapdix.model.request.asset.PortfolioDetailRequest;
import rapdix.model.request.asset.PortfolioFundsHistoryRequest;
import rapdix.model.request.asset.UserAllPortfolioRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.asset.AssetVO;
import rapdix.model.vo.asset.AssetPortfolioHistoryVO;

import java.util.List;
import java.util.Map;

public interface AssetAPIService {
    ApiResponse<AssetPortfolioHistoryVO>  portfolioFundsHistory(PortfolioFundsHistoryRequest request);
    ApiResponse<PageEntity<AssetVO>> portfolioDetail(PortfolioDetailRequest request);
    ApiResponse<Map<String,List<AssetVO>>> UserAllPortfolio(UserAllPortfolioRequest request);
}
