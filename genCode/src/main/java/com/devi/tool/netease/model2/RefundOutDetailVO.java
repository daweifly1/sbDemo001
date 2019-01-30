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
    private String id;
    @ApiModelProperty(value = "头表id")
    private String headId;
    @ApiModelProperty(value = "行号")
    private Integer indexNo;
    @ApiModelProperty(value = "厂矿物料编码")
    private String materialNo;
    @ApiModelProperty(value = "物料描述")
    private String materialDesc;
    @ApiModelProperty(value = "物料型号")
    private String materialModel;
    @ApiModelProperty(value = "技术参数")
    private String technicalParameters;
    @ApiModelProperty(value = "品牌")
    private String brand;
    @ApiModelProperty(value = "单位")
    private String unit;
    @ApiModelProperty(value = "数量")
    private BigDecimal quantity;
    @ApiModelProperty(value = "需求日期")
    private Date needDate;
    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;
    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "接收人")
    private String recipient;
    @ApiModelProperty(value = "附件名称")
    private String annexName;
    @ApiModelProperty(value = "附件url")
    private String annexUrl;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "库存数量")
    private BigDecimal inventoryNum;
    @ApiModelProperty(value = "安全库存数量")
    private BigDecimal safeInventoryNum;
    @ApiModelProperty(value = "前三月领用量")
    private BigDecimal threeMonthReceiveNum;
    @ApiModelProperty(value = "已申报计划")
    private BigDecimal applyPurchaseNum;

    private Date createDate;
    private String createId;
    private Date updateDate;
    private String updateId;
}
