package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@TableComment(value = "采购退出库详情记录表")
@Data
public class PurchaseRefundStockDetail {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "主表id")
    private String refundId;

    @ApiModelProperty(value = "退货单编码")
    private String refundCode;

    @ApiModelProperty(value = "物料编码")
    private BigDecimal materialNo;

    @ApiModelProperty(value = "接收号")
    private String erpNo;

    @ApiModelProperty(value = "ERP入库的交易ID")
    private String erpDeliveryTrxId;

    @ApiModelProperty(value = "入库单号")
    private String stockeInNo;

    @ApiModelProperty(value = "入库行ID")
    private String stockInDetailId;

    @ApiModelProperty(value = "计划退库数量")
    private BigDecimal planRefundAmount;

    @ApiModelProperty(value = "已经执行退库数量")
    private BigDecimal exeRefundAmount;

//    @ApiModelProperty(value = "本次退库数量，可以不持久化，向exeRefundAmount累加")
//    private BigDecimal curRefundAmount;

    @ApiModelProperty(value = "退货原因")
    private String memo;

    @ApiModelProperty(value = "退货状态,0初始，1部分出库，2出库完成，3 结单")
    private Integer status;

    @ApiModelProperty(value = "ERP处理结果")
    private String erpProcessMessage;

    @ApiModelProperty(value = "传输erp状态")
    private Integer erpStatus;

}
