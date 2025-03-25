package rapdix.model.vo.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFeeVo {

    private String portfolioId;
    private String exchange;
    private String instType;
    private String effDate;
    private String maker;
    private String taker;

}
