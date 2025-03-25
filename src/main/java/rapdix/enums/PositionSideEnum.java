package rapdix.enums;

public enum PositionSideEnum {
    LONG("LONG"),SHORT("SHORT"),NONE("NONE");
    private String value;
    PositionSideEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
