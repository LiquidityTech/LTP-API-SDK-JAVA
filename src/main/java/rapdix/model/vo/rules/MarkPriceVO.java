package rapdix.model.vo.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarkPriceVO {
    @Builder.Default
    private String publicChannelTypeEnum = "MARK_PRICE";

    /**
     * universal identifier
     */
    private String sym;

    /**
     * Marked price
     */
    private String markPrice;

    /**
     * timestamp
     */

    private long timestamp;
}
