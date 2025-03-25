package rapdix.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CurrentOpenOrdersRequest {
    private String sym;
    private String exchange;
    private String businessType;
    private String begin;
    private String end;
    private String page;
    private String pageSize;
}
