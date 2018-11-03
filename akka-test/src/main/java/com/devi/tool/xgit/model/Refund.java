package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购退出库申请主表 VO类
 */
@TableComment(value = "采购退出库申请主表")
@Data
@ToString
public class Refund implements Serializable {
    private static final long serialVersionUID = -6911515990620138680L;
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

    @ApiModelProperty(value = "添加人名称")
    private String createName;
    @ApiModelProperty(value = "制单时间")
    private Date createDate;

    @ApiModelProperty(value = "退货状态,1创建，2待出库，3部分出库，4出库完成，5 结单，常量InvoiceCons.RefundStatus")
    private Integer status;
    @ApiModelProperty(value = "传输erp状态，0失败，1成功")
    private Integer erpStatus;

    @ApiModelProperty(value = "仓库编码")
    private String warehouseCode;

    @ApiModelProperty(value = "库区编码")
    private String areaCode;
}
