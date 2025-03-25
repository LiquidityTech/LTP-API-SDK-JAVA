package rapdix.model.vo.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author axia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoinDiscountVO {

    private String coin;

    private String discount;
}
