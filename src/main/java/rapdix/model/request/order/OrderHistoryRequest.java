package rapdix.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderHistoryRequest {
    private String sym;
    private String exchange;
    private String businessType;
    private String begin;
    private String end;
    private Boolean filterExecuted;
    private String page;
    private String pageSize;
}
