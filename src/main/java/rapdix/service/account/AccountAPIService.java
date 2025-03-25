package rapdix.service.account;

import rapdix.model.request.account.AccountPositionModeRequest;
import rapdix.model.request.account.AccountQueryRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.AccountVO;

import java.util.List;

public interface AccountAPIService {
    ApiResponse<List<AccountVO>> queryAccount(AccountQueryRequest request);
    ApiResponse<Void> changeAccountPositionMode(AccountPositionModeRequest accountPMRequset);
}
