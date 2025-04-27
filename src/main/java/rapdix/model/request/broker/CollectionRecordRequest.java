package rapdix.model.request.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CollectionRecordRequest {
    private String exchange;
    private String instType;
    private String coin;
    private String subPortfolioId;
    private String sym;
    private String begin;
    private String end;
    private String pageNum;
    private String pageSize;
}
