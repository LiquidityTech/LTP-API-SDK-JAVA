package rapdix.service.statement;

import rapdix.model.PageEntity;
import rapdix.model.request.statement.StatementRequest;
import rapdix.model.request.statement.UserTradingStatsRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.statement.AssetStatementVO;
import rapdix.model.vo.statement.UserTradingStatsVO;

public interface StatementAPIService {
    ApiResponse<PageEntity<AssetStatementVO>> queryStatement(StatementRequest request);
    ApiResponse<UserTradingStatsVO> queryUserTradingStats(UserTradingStatsRequest request);
}
