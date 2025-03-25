package rapdix.model.request.position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PositionPortfolioHistoryRequest {
    private String sym;
    private String exchange;
    private String begin;
    private String end;
    private String page;
    private String pageSize;
}
