package rapdix.model.vo.position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionPortfolioVO {
    /**
     * Position ID
     */
    private String positionId;
    private String portfolioId;
    @Builder.Default
    private String sym = "";
    /**
     * Position side
     */
    @Builder.Default
    private String positionSide = "NET";
    /**
     * Initial margin of the position
     */
    @Builder.Default
    private String positionMargin = "";

    /**
     * Maintenance margin of the position
     */
    @Builder.Default
    private String positionMM = "";
    /**
     * Position quantity (currently refers to the number of contracts)
     */
    @Builder.Default
    private String positionQty = "";

    /**
     * Position value
     */
    @Builder.Default
    private String positionValue = "";
    /**
     * Unrealized profit and loss
     */
    @Builder.Default
    private String unrealizedPNL = "";
    /**
     * Unrealized profit and loss rate
     */
    @Builder.Default
    private String unrealizedPNLRate = "";
    /**
     * Average entry price (cost price)
     */
    @Builder.Default
    private String avgPrice = "";
    /**
     * Snapshot of the mark price of the position
     */
    @Builder.Default
    private String markPrice = "";
    /**
     * Leverage used for opening the position
     */
    @Builder.Default
    private String leverage = "1";
    /**
     * Maximum leverage allowed
     */
    @Builder.Default
    private String maxLeverage = "20";
    /**
     * Risk level tier
     */
    @Builder.Default
    private String riskLevel = "1";

    /**
     * Total fees incurred for the position
     */
    private String fee;

    /**
     * Funding fee
     */
    private String fundingFee;

    /**
     * Creation time
     */
    private String createAt;
    /**
     * Update time
     */
    private String updateAt;

    /**
     * Estimated liquidation price of the position
     */
    private String liqPrice;

    /**
     * Take-profit and stop-loss orders
     */
    //private List<AlgoOrderVO> tpslOrder;
}