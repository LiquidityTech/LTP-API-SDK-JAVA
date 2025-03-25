package rapdix.model.request.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SubPortfolioFeeRateRequest {
    private String portfolioId;
    private String exchange;
    private String instType;
    private String chgType;
    private String chgTaker;
    private String chgMaker;
    private String effDate;

}
