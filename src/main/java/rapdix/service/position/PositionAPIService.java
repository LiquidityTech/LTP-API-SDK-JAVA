package rapdix.service.position;

import rapdix.model.PageEntity;
import rapdix.model.request.position.*;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.position.*;

import java.util.List;

public interface PositionAPIService {
    ApiResponse<Void> setLeverage(LeverageSetRequest request);
    ApiResponse<List<LeverageVO>> getLeverage(LeverageGetRequest request);
    ApiResponse<List<PositionVO>> closePosition(PositionCloseRequest request);
    ApiResponse<List<PositionsVO>> closePositions(PositionsCloseRequest request);
    ApiResponse<List<PositionPortfolioVO>> queryPortfolioPosition(PositionPortfolioRequest request);
    ApiResponse<PageEntity<PositionHistoryVO>> queryPortfolioHistoryPosition(PositionPortfolioHistoryRequest request);
}
