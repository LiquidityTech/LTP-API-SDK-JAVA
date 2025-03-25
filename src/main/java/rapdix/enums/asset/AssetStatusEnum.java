package rapdix.enums.asset;

public enum AssetStatusEnum {
    PENDING(0),SUCCEEDED(1),FAILED(2);
    private int value;
    AssetStatusEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
