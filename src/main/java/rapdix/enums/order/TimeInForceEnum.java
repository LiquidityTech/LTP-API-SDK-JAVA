package rapdix.enums.order;
/**
 * GTC（Good-Till-Cancelled, IOC（Immediate-Or-Cancel）,FOK（Fill-Or-Kill）,GTX（Good-Till-Crossed）
 * */
public enum TimeInForceEnum {
    GTC("GTC"),IOC("IOC"),FOK("FOK"),GTX("GTX");
    private String value;
    TimeInForceEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
