package rapdix.model.request.transaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArchiveTransactionPageableRequest {
    private String orderId;
    private String sym;
    private String exchange;
    private String businessType;
    private String begin;
    private String end;
    private String page;
    private String pageSize;
} 