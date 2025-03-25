package rapdix.model.vo.statement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import rapdix.model.dto.UserTradingStatsDTO;

import java.util.List;

/**
 * @author cookieyuan
 */
@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTradingStatsVO {

    @JsonIgnore
    private String userId;
    private String begin;
    private String end;
    private String allSpot;
    private String allPerp;
    private List<UserTradingStatsDTO> details;

}
