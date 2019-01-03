package com.devi.tool.xgit.temp;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@TableComment(value = "单号承包结算关系表")
@Data
@ToString
public class MaterialSettlementRel {
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "物料编码", required = true)
    private String materialCode;

    @ApiModelProperty(value = "物料描述")
    private String materialDesc;

    @ApiModelProperty(value = "物料单位")
    private String unit;

    @ApiModelProperty(value = "结算物料编码", required = true)
    private String settlementMaterialCode;

    @ApiModelProperty(value = "结算物料描述")
    private String settlementMaterialDesc;

    @ApiModelProperty(value = "物料单位")
    private String settlementUnit;

    @ApiModelProperty(value = "创建人Id")
    private String createId;

    @ApiModelProperty(value = "创建人名称")
    private String createName;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "更新人Id")
    private String updateId;

    @ApiModelProperty(value = "更新人名称")
    private String updateName;

    @ApiModelProperty(value = "更新日期")
    private Date updateDate;

    @ApiModelProperty(value = "组织id")
    private String orgId;

}