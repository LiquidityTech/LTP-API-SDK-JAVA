package rapdix.enums.account;

public enum AccountStatusEnum {
    NORMAL("NORMAL"), MARGIN_CALL("MARGIN_CALL"),
    CANCEL_OPEN(" CANCEL_OPEN"), CANCEL_ALL("CANCEL_ALL"),
    LIQUIDATING("CANCEL_ALL"), TAKEOVER("CANCEL_ALL");
    private String value;
    AccountStatusEnum(String value)
    {
        this.value = value;
    }
    public String getValue() {
        return value;
    }


}
