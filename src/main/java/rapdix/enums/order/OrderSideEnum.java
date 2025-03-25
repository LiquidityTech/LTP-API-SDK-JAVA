package rapdix.enums.order;

public enum OrderSideEnum {
    BUY("buy"),SELL("sell");
    private String value;
    OrderSideEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
