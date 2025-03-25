package rapdix.constants;

public class RapidxAPIConstants {
    //Account
    public static final String ACCOUNT = "/api/v1/trading/account";
    //Assets
    public static final String ASSET_PORTFOLIO_FUNDS_HISTORY = "/api/v1/asset/bills";
    public static final String ASSET_PORTFOLIO_DETAIL = "/api/v1/trading/portfolio/assets";
    public static final String ASSET_ALL_PORTFOLIO = "/api/v1/user/asset";
    //Order
    public static final String ORDER = "/api/v1/trading/order";
    public static final String ORDERS = "/api/v1/trading/orders";
    public static final String ORDER_HISTORY = "/api/v1/trading/history/orders";
    public static final String ORDER_HISTORY_ARCHIVE = "/api/v1/trading/archive/history/orders";
    public static final String ORDER_CANCEL_ALL = "/api/v1/trading/cancelAll";
    //Position
    public static final String LEVERAGE_SET = "/api/v1/trading/position/leverage";
    public static final String LEVERAGE_GET = "/api/v1/trading/perp/leverage";
    public static final String POSITION = "/api/v1/trading/position";
    public static final String POSITIONS = "/api/v1/trading/positions";
    public static final String POSITIONS_HISTORY = "/api/v1/trading/history/position";
    //Transaction
    public static final String TRANSACTION = "/api/v1/trading/executions";
    public static final String TRANSACTION_PAGEABLE = "/api/v1/trading/executions/pageable";
    public static final String TRANSACTION_PAGEABLE_ARCHIVE = "/api/v1/trading/archive/executions/pageable";
    //Statement
    public static final String STATEMENT = "/api/v1/trading/statement";
    public static final String USER_TRADING_STATS = "/api/v1/trading/user/tradingStats";
    //Trading Rules
    public static final String MARGIN_LEVERAGE = "/api/v1/trading/margin/leverage";
    public static final String SYM_INFO = "/api/v1/trading/sym/info";
    public static final String FUNDING_RATE = "/api/v1/market/fundingRate";
    public static final String MARK_PRICE = "/api/v1/market/markPrice";
    public static final String USER_FEE_RATE = "/api/v1/trading/userFeeRate";
    public static final String POSITION_TIER = "/api/v1/trading/positionBracket";
    public static final String LOAN_TIER = "/api/v1/trading/loan/info";
    public static final String DISCOUNT_RATE = "/api/v1/trading/coin/discount";
    public static final String USER_INTEREST = "/api/v1/interest/user";
    //broker
    public static final String BROKER_POSITION_TIER = "/api/v1/trading/broker/positionBracket";
    public static final String SUB_PORTFOLIO_FEE_RATE = "/api/v1/broker/subFeeRate";
    public static final String BROKER_FEE_RATE = "/api/v1/broker/feeRate";
    public static final String BROKER_SUB_FEE_RATE = "/api/v1/broker/sub/feeRate";
    public static final String CLEARING_STATEMENT = "/api/v1/broker/clearingStatement";
    public static final String COLLECTION_RECORD = "/api/v1/broker/collectionRecord";

}
