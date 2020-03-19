package com.nongxin.terminal.vo.app;

import java.math.BigDecimal;

public class SpecialVo {

    private BigDecimal max_value;

    private BigDecimal min_value;

    private BigDecimal avg_value;

    public BigDecimal getMax_value() {
        return max_value.setScale(1, BigDecimal.ROUND_HALF_UP);
    }

    public void setMax_value(BigDecimal max_value) {
        if (max_value!=null){
            this.max_value = max_value.setScale(1, BigDecimal.ROUND_HALF_UP);
        }else{
            this.max_value = max_value;
        }
    }

    public BigDecimal getMin_value() {
        return min_value.setScale(1, BigDecimal.ROUND_HALF_UP);
    }

    public void setMin_value(BigDecimal min_value) {
        if(min_value!=null){
            this.min_value = min_value.setScale(1, BigDecimal.ROUND_HALF_UP);
        }else{
            this.max_value = min_value;
        }

    }

    public BigDecimal getAvg_value() {
        return avg_value.setScale(1, BigDecimal.ROUND_HALF_UP);
    }

    public void setAvg_value(BigDecimal avg_value) {
        if(avg_value!=null){
            this.avg_value = avg_value.setScale(1, BigDecimal.ROUND_HALF_UP);
        }else{
            this.avg_value = avg_value;
        }

    }
}
