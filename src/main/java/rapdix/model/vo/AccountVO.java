package rapdix.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO {

    @JsonIgnore
    private String userId;

    private String portfolioId;
    /**
     * The exchange corresponding to the account
     */
    private String exchangeType;
    /**
     * Initial margin occupied by the account
     */
    @Deprecated
    @JsonIgnore
    private String margin;
    /**
     * Account equity
     */
    private String equity;
    /**
     * Maintenance margin of the account
     */
    private String maintainMargin;
    /**
     * Position value of the account
     */
    private String positionValue;
    /**
     * Unified maintenance margin ratio of the account
     */
    private String uniMMR = "99999999";
    /**
     * Account status
     */
    private String accountStatus;

    /**
     * Total margin value
     */
    private String marginValue;
    /**
     * Frozen margin
     */
    private String frozenMargin;
    /**
     * Perpetual contract margin
     */
    private String perpMargin;
    /**
     * Debt margin
     */
    private String debtMargin;
    /**
     * Margin loss from opening and closing positions
     */
    private String openLossMargin;
    /**
     * Valid margin
     */
    private String validMargin;
    /**
     * Available margin
     */
    private String availableMargin;
    /**
     * Unrealized profit and loss
     */
    private String upnl;

    /**
     * Position mode
     */
    private String positionMode;

    @JsonIgnore
    private String perpAvailableMargin;

    @JsonIgnore
    private Long updateAt;
}