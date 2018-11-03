package com.devi.tool.netease.model2;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * 领料出库单
 */
@Data
@ToString
public class RefundOutDetailVO {
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "物料编码")
    private String materialNo;

    /**
     * 出库数量
     */
    @ApiModelProperty(value = "退货数量")
    private BigDecimal amountOut;
}
