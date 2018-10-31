package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@TableComment(value = "采购退出库申请主表")
@Data
public class PurchaseRefundStock {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "退货单号,TH开头")
    private String refundCode;

    @ApiModelProperty(value = "合同号")
    private String contractNo;

    @ApiModelProperty(value = "是否条码管理,1是，0否")
    private Integer barcodeFlag;

    @ApiModelProperty(value = "原因")
    private String reason;

    @ApiModelProperty(value = "创建的公司")
    private String orgId;

    @ApiModelProperty(value = "添加人ID")
    private String createId;

    @ApiModelProperty(value = "制单时间")
    private Date createDate;

    @ApiModelProperty(value = "退货状态,0初始，1部分出库，2出库完成，3 结单")
    private Integer status;

    @ApiModelProperty(value = "传输erp状态")
    private Integer erpStatus;
}
