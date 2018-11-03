package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 采购退出库详情记录表 VO类
 */
@TableComment(value = "采购退出库详情记录表")
@Data
@ToString
public class RefundDetail implements Serializable {
    private static final long serialVersionUID = 1802108197360587580L;
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "主表id")
    private String refundId;
    @ApiModelProperty(value = "退货单编码")
    private String refundCode;
    @ApiModelProperty(value = "物料编码")
    private String materialNo;
    @ApiModelProperty(value = "接收号")
    private String erpNo;
    @ApiModelProperty(value = "计划退库数量")
    private BigDecimal planRefundAmount;
    @ApiModelProperty(value = "已经执行退库数量")
    private BigDecimal exeRefundAmount;
    @ApiModelProperty(value = "ERP入库的交易ID")
    private String erpDeliveryTrxId;
    @ApiModelProperty(value = "入库单号")
    private String stockeInNo;
    @ApiModelProperty(value = "入库行ID")
    private String stockInDetailId;
    @ApiModelProperty(value = "退货原因")
    private String reason;
    @ApiModelProperty(value = "退货状态,1创建，2待出库，3部分出库，4出库完成，5 结单，常量InvoiceCons.RefundStatus")
    private Integer status;
    @ApiModelProperty(value = "ERP处理结果")
    private String erpProcessMessage;
    @ApiModelProperty(value = "erp处理状态，0失败，1成功")
    private Integer erpStatus;

    @ApiModelProperty(value = "储位")
    private String locationCode;
}
