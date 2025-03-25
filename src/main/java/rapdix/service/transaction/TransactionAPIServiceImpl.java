package rapdix.service.transaction;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import rapdix.client.HttpClient;
import rapdix.client.RapdixAPIClient;
import rapdix.constants.RapidxAPIConstants;
import rapdix.model.PageEntity;
import rapdix.model.request.transaction.ArchiveTransactionPageableRequest;
import rapdix.model.request.transaction.TransactionPageableRequest;
import rapdix.model.request.transaction.TranscationRequest;
import rapdix.model.response.ApiResponse;
import rapdix.model.vo.ArchiveTransactionVO;
import rapdix.model.vo.TransactionVO;

import java.util.List;

public class TransactionAPIServiceImpl implements TransactionAPIService {
    private final HttpClient httpClient;
    private final String apiKey;
    private final String secretKey;
    private final String urlBase;

    public TransactionAPIServiceImpl(RapdixAPIClient client) {
        this.apiKey = client.getApiKey();
        this.secretKey = client.getSecretKey();
        this.urlBase = client.getBaseUrl();
        this.httpClient = client.getHttpClient();
    }

    /**
     * Query Transactions
     *
     * @param request TranscationRequest request
     * @return ApiResponse<List<TransactionVO>>
     */
    @Override
    public ApiResponse<List<TransactionVO>> queryTransaction(TranscationRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.TRANSACTION, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<List<TransactionVO>>>() {
        });
    }

    /**
     * Query Portfolio History PositionQuery Transactions (Pageable)
     *
     * @param request TransactionPageableRequest request
     * @return ApiResponse<PageEntity<TransactionVO>>
     */
    @Override
    public ApiResponse<PageEntity<TransactionVO>> queryTransactionPageable(TransactionPageableRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.TRANSACTION_PAGEABLE, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<TransactionVO>>>() {
        });
    }

    /**
     * Query Archived Transactions (Pageable)
     * Get transactions from the past 7 to 90 days.
     *
     * @param request ArchiveTransactionPageableRequest request
     * @return ApiResponse<PageEntity<ArchiveTransactionVO>>
     */
    @Override
    public ApiResponse<PageEntity<ArchiveTransactionVO>> queryArchiveTransactionPageable(ArchiveTransactionPageableRequest request) {
        String jsonRequest = JSON.toJSONString(request);
        String body = this.httpClient.getInstance().doGet(urlBase + RapidxAPIConstants.TRANSACTION_PAGEABLE_ARCHIVE, jsonRequest, apiKey, secretKey);
        return JSON.parseObject(body, new TypeReference<ApiResponse<PageEntity<ArchiveTransactionVO>>>() {
        });
    }
}
