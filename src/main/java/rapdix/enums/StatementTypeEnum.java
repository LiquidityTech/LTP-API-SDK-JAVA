package rapdix.enums;

public enum StatementTypeEnum {
    FUNDING_FEE("FUNDING_FEE"),DEDUCT_INTEREST("DEDUCT_INTEREST"),LIQUIDATION_FEE("LIQUIDATION_FEE");
    private String value;
    StatementTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
