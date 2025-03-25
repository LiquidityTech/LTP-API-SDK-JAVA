package rapdix.model.request.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ClearingStatementRequest {
    private String exchange;
    private String instType;
    private String coin;
    private String begin;
    private String end;
    private String pageNum;
    private String pageSize;
}
