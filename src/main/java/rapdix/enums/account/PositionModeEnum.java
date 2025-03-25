package rapdix.enums.account;

public enum PositionModeEnum {
    NET("NET"),BOTH("BOTH");
    private String value;
    PositionModeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
