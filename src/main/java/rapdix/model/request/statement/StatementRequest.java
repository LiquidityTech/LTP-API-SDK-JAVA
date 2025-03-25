package rapdix.model.request.statement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StatementRequest {
    private String coin;
    private String sym;
    private String statementType;
    private String exchange;
    private String startTime;
    private String endTime;
    private String page;
    private String pageSize;
}
