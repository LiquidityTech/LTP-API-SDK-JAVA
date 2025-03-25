package rapdix.model.vo.rules;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 合约和现货结构统一
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SymbolInfoVO {

    private String sym;
    private String originalSymbol;
    private String state;
    private String pricePrecision;
    private String qtyPrecision;
    private String lotSize;
    private String tickSize;
    private String minNotional;
    private String maxLimitSize;
    private String maxMarketSize;
    private String maxNumOrders;

    /**
     * 期货特有
     */
    private String minSize;
    private String contractSize;
    private String defaultLeverage;

    /**
     * 现货特有
     */
    private String minLimitSize;
    private String minMarketQuoteSize;
    private String maxMarketQuoteSize;
    private String minMarketBaseSize;
    private String maxMarketBaseSize;

}
