package rapdix.client;

import rapdix.service.account.AccountAPIService;
import rapdix.service.account.AccountAPIServiceImpl;
import rapdix.service.asset.AssetAPIService;
import rapdix.service.asset.AssetAPIServiceImpl;
import rapdix.service.broker.BrokerAPIService;
import rapdix.service.broker.BrokerAPIServiceImpl;
import rapdix.service.order.OrderAPIService;
import rapdix.service.order.OrderAPIServiceImpl;
import rapdix.service.position.PositionAPIService;
import rapdix.service.position.PositionAPIServiceImpl;
import rapdix.service.statement.StatementAPIService;
import rapdix.service.statement.StatementAPIServiceImpl;
import rapdix.service.rules.TradingRulesAPIService;
import rapdix.service.rules.TradingRulesAPIServiceImpl;
import rapdix.service.transaction.TransactionAPIService;
import rapdix.service.transaction.TransactionAPIServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RapdixAPIClient {
    private final String apiKey;
    private final String SecretKey;
    private final String baseUrl;
    private final HttpClient httpClient;
    private RequestTimingInterceptor.RequestTimingListener timingListener;

    private AccountAPIService accountService;
    private AssetAPIService assetService;
    private BrokerAPIService brokerService;
    private OrderAPIService orderService;
    private PositionAPIService positionService;
    private StatementAPIService statementService;
    private TradingRulesAPIService tradingRulesService;
    private TransactionAPIService transactionService;

    public RapdixAPIClient(String apiKey, String SecretKey) {
        this.apiKey = apiKey;
        this.SecretKey = SecretKey;
        this.baseUrl = "https://api.liquiditytech.com";
        this.httpClient = new OkHttpClientImpl();
    }
    public RapdixAPIClient(String apiKey, String SecretKey,HttpClient httpClient) {
        this.apiKey = apiKey;
        this.SecretKey = SecretKey;
        this.baseUrl = "https://api.liquiditytech.com";
        this.httpClient = httpClient;
    }

    public void setRequestTimingListener(RequestTimingInterceptor.RequestTimingListener listener) {
        this.timingListener = listener;
        if (httpClient instanceof OkHttpClientImpl) {
            ((OkHttpClientImpl) httpClient).setTimingListener(listener);
        }
    }

    public AccountAPIService account() {
        if (accountService == null) {
            accountService = new AccountAPIServiceImpl(this);
        }
        return accountService;
    }
    public AssetAPIService asset() {
        if (assetService == null) {
            assetService = new AssetAPIServiceImpl(this);
        }
        return assetService;
    }
    public BrokerAPIService broker() {
        if (brokerService == null) {
            brokerService = new BrokerAPIServiceImpl(this);
        }
        return brokerService;
    }
    public OrderAPIService order() {
        if (orderService == null) {
            orderService = new OrderAPIServiceImpl(this);
        }
        return orderService;
    }
    public PositionAPIService position() {
        if (positionService == null) {
            positionService = new PositionAPIServiceImpl(this);
        }
        return positionService;
    }
    public StatementAPIService statement() {
        if (statementService == null) {
            statementService = new StatementAPIServiceImpl(this);
        }
        return statementService;
    }
    public TradingRulesAPIService tradingRules() {
        if (tradingRulesService == null) {
            tradingRulesService = new TradingRulesAPIServiceImpl(this);
        }
        return tradingRulesService;
    }
    public TransactionAPIService transaction() {
        if (transactionService == null) {
            transactionService = new TransactionAPIServiceImpl(this);
        }
        return transactionService;
    }

}
