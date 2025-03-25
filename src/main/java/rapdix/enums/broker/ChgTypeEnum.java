package rapdix.enums.broker;

public enum ChgTypeEnum {
    ABSOLUTE("ABSOLUTE"),PERCENTAGE("PERCENTAGE");
    private String value;
    ChgTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
