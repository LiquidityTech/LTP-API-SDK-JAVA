    package rapdix.model.vo.asset;
    
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.core.JsonProcessingException;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    import java.math.BigDecimal;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class AssetVO {
        @JsonIgnore
        private String userId;
        private String portfolioId;
        private String coin;
        private String exchangeType;
    
        /**
         * Transferable funds
         */
        private String balance;
        /**
         * Available, calculated by formula
         */
        @Builder.Default
        private String available = "";
    
        /**
         * order frozen, transfer frozen
         */
        @Builder.Default
        private String frozen = "";
    
        /**
         * debt
         */
        @Builder.Default
        private String debt = "";
    
        /**
         * equity
         */
        @Builder.Default
        private String equity = "";
    
        private String createAt;
        private String updateAt;
    
        /**
         * Borrowed funds for leverage, reserved field
         */
        private String borrow;
        /**
         * Overdrawn amount
         */
        private String overdraw;
        /**
         * Index price
         */
        private String indexPrice;
        /**
         * margin value of the currency
         */
        private String marginValue;
    
        /**
         * Virtual borrowed funds, reserved field
         */
        private String virtualBorrow;
        /**
         * Unrealized profit and loss
         */
        private String upnl;
        /**
         * Debt margin of the currency
         */
        private String debtMargin;
        /**
         * Perpetual contract margin of the currency
         */
        private String perpMargin;
    
        /**
         * Maximum transferable asset amount
         */
        private String maxTransferable;
    
        /**
         * Value of equity
         */
        private String equityValue;
    
        public static void main(String[] args) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            AssetVO assetVO = new AssetVO();
            assetVO.setEquity("-1");
            System.out.println(objectMapper.writeValueAsString(assetVO));
        }
    
        public String getDebt() {
            return new BigDecimal(this.equity).min(BigDecimal.ZERO).abs().stripTrailingZeros().toPlainString();
        }
    }
