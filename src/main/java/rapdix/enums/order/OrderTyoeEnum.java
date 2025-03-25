package rapdix.enums.order;

public enum OrderTyoeEnum {
    LIMIT("LIMIT"),MARKET("MARKET");
    private String value;
    OrderTyoeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
