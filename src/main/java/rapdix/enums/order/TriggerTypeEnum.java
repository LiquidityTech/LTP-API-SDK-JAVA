package rapdix.enums.order;

public enum TriggerTypeEnum {
    LAST_PRICE("LAST_PRICE"),MARKET_PRICE("MARKET_PRICE");
    private String value;
    TriggerTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
