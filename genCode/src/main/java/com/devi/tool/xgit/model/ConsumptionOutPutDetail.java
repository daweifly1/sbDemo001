package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@TableComment(value = "单耗承包产出详细信息表")
@Data
@ToString
public class ConsumptionOutPutDetail {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "表头单据编号", required = true)
    private String code;

    @ApiModelProperty(value = "表头主键", required = true)
    private String headerId;

    @ApiModelProperty(value = "领料单编码", required = true)
    private String pickingNo;

    @ApiModelProperty(value = "出库时间")
    private Date pickingDate;

    @ApiModelProperty(value = "物料编码", required = true)
    private String materialCode;

    @ApiModelProperty(value = "物料描述")
    private String materialDesc;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "出库数量")
    private BigDecimal outAmount;

    @ApiModelProperty(value = "已经结算数量")
    private BigDecimal totleSettlementAmount;

    @ApiModelProperty(value = "状态，0新建，1完结", required = true)
    private Integer status;

    @ApiModelProperty(value = "本次结算数量")
    private BigDecimal settlementAmount;

    @ApiModelProperty(value = "结算物料编码")
    private String settlementMaterialCode;

    @ApiModelProperty(value = "结算物料描述")
    private String settlementMaterialDesc;

    @ApiModelProperty(value = "结算物料单位")
    private String settlementUnit;

    @ApiModelProperty(value = "更新人Id")
    private String updateId;

    @ApiModelProperty(value = "更新人名称")
    private String updateName;

    @ApiModelProperty(value = "更新日期")
    private Date updateDate;
}