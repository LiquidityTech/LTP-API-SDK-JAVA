package rapdix.model.vo.position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionHistoryVO {
    /**
     * 仓位id
     */
    private String positionId;

    private String portfolioId;

    private String portfolioName;
    @Builder.Default
    private String sym = "";

    //以下为仓位历史字段
    /**
     * Type of closed position
     */
    private String closedType;
    @Builder.Default
    private String closedPnl = "";
    @Builder.Default
    private String closedPnlRatio = "";

    @Builder.Default
    private String closedAvgPrice = "";

    @Builder.Default
    private String maxPositionQty = "";
    @Builder.Default
    private String closedQty = "";
    @Builder.Default
    private String liqFee = "";
    @Builder.Default
    private String fundingFee = "";
    @Builder.Default
    private String fee = "";
    @Builder.Default
    private String openAvgPrice = "";

    private Integer leverage;

    private String positionHistorySide;

    /**
     * Position Patterns When Closing Positions
     */
    @Builder.Default
    private String positionMode = "NET";

    /**
     * created time
     */
    private String createAt;
    /**
     * updated time
     */
    private String updateAt;
}
