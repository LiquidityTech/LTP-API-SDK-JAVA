package rapdix.model.vo.broker;

import lombok.*;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClearingStatementVO {


    private String id;
    private String portfolioId;
    private String userId;
    private String exchangeType;
    private String businessType;
    private String transactionId;
    private String statementFlowType;
    private String coin;
    private String amount;
    private String createAt;
    private String updateAt;
}
