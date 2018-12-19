package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@TableComment(value = "盘点单详细表")
@Data
@ToString
public class InventoryCheckDetail {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "主表id")
    private String checkId;

    @ApiModelProperty(value = "机构id")
    private String orgId;

    @ApiModelProperty(value = "盘点单号")
    private String checkOrderNo;

    @ApiModelProperty(value = "物料号码")
    private String materialsNo;

    @ApiModelProperty(value = "条码")
    private String barCode;

    @ApiModelProperty(value = "系统中数量")
    private BigDecimal sysAmount;

    @ApiModelProperty(value = "实际盘点数量")
    private BigDecimal actAmount;

    @ApiModelProperty(value = "仓库代码")
    private String warhouseCode;

    @ApiModelProperty(value = "区域代码")
    private String areaCode;

    @ApiModelProperty(value = "储位代码")
    private String loactionCode;

    @ApiModelProperty(value = "是否已经调整")
    private Integer adjusted;
    @ApiModelProperty(value = "出入库单据")
    private String documentNo;
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;
    @ApiModelProperty(value = "结果类型 0正常1盘亏2盘盈")
    private Integer resultType;
    @ApiModelProperty(value = "0未盘点1已盘点")
    private Integer state;
    @ApiModelProperty(value = "盘点人id")
    private String inventoryUserId;
    @ApiModelProperty(value = "盘点人Name")
    private String inventoryUserName;
    @ApiModelProperty(value = "保管员id")
    private String depositaryId;

    @ApiModelProperty(value = "保管员NAME")
    private String depositaryName;
    @ApiModelProperty(value = "盘点时间")
    private Date inventoryDate;
    @ApiModelProperty(value = "调整人id")
    private String adjustUserId;
    @ApiModelProperty(value = "调整人name")
    private String adjustUserName;
    @ApiModelProperty(value = "调整时间")
    private Date adjustDate;

    @ApiModelProperty(value = "是否协议类型 0否1是")
    private Integer agreementFlag;

    @ApiModelProperty(value = "协议号")
    private String agreementCode;
}