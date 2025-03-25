package rapdix.service.transaction;

import rapdix.model.PageEntity;
import rapdix.model.request.transaction.ArchiveTransactionPageableRequest;
import rapdix.model.request.transaction.TransactionPageableRequest;
import rapdix.model.request.transaction.TranscationRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.ArchiveTransactionVO;
import rapdix.model.vo.TransactionVO;

import java.util.List;

public interface TransactionAPIService {
    /**
     * Query Transactions
     *
     * @param request TranscationRequest request
     * @return ApiResponse<List<TransactionVO>>
     */
    ApiResponse<List<TransactionVO>> queryTransaction(TranscationRequest request);

    /**
     * Query Portfolio History PositionQuery Transactions (Pageable)
     *
     * @param request TransactionPageableRequest request
     * @return ApiResponse<PageEntity<TransactionVO>>
     */
    ApiResponse<PageEntity<TransactionVO>> queryTransactionPageable(TransactionPageableRequest request);

    /**
     * Query Archived Transactions (Pageable)
     * Get transactions from the past 7 to 90 days.
     *
     * @param request ArchiveTransactionPageableRequest request
     * @return ApiResponse<PageEntity<ArchiveTransactionVO>>
     */
    ApiResponse<PageEntity<ArchiveTransactionVO>> queryArchiveTransactionPageable(ArchiveTransactionPageableRequest request);
}
