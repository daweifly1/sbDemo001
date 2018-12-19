package com.devi.tool.netease.model2;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 领料出库单
 */
@Data
@ToString
public class RefundOutDetailVO {
    @ApiModelProperty(value = "合同编号,收发货单有")
    private String purchaseNo;

    @ApiModelProperty(value = "合同类型（1采购订单，2年度协议），收发货单有")
    private Integer contractType;

    @ApiModelProperty(value = "供应商编码，,收发货单有")
    private String supplierNo;

    @ApiModelProperty(value = "供应商名称，收发货单有")
    private String supplierName;
}
