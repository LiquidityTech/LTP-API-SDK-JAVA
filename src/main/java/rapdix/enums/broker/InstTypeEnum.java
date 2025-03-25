package rapdix.enums.broker;

public enum InstTypeEnum {
    SPOT("spot"),PERP("perp");
    private String value;
    InstTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
