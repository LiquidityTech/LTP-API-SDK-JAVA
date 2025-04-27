package rapdix.model.request.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class TranscationRequest {
    private String orderId;
    private String sym;
    private String exchange;
    private String businessType;
    private String begin;
    private String end;
    private String limit;
}
