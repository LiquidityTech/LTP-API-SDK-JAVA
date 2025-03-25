package rapdix.enums.order;

public enum OrderStateEnum {
    NEW("new"),OPEN("open"),CANCELLED("cancelled"),
    FILLED("filled"),PARTIALLY_FILLED("partially_filled"),
    REJECTED("rejected"),FAIL("fail");
    private String value;
    OrderStateEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
