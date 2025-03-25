package rapdix.enums.asset;

public enum AssetTypeEnum {
    DEPOSIT(0),TRANSFER(1),WITHDRAW(2);
    private int value;
    AssetTypeEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
