package rapdix.model.vo.statement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetStatementVO {
    @JsonIgnore
    private Long userId;
    private Long portfolioId;
    private String requestId;
    private String statementId;
    private String coin;
    private String sym;
    private String statementType;
//    private StatementAction statementAction;
    private String exchangeType;
    private String businessType;
    @Builder.Default
    private String beforeAvailable = "";
    @Builder.Default
    private String afterAvailable = "";
    @Builder.Default
    private String beforeOverdraw = "";
    @Builder.Default
    private String afterOverdraw = "";
    private Long createAt;

}
