package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@TableComment(value = "盘点单主表")
@Data
@ToString
public class InventoryCheck {
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "盘点单号")
    private String checkOrderNo;

    @ApiModelProperty(value = "盘点单简单描述")
    private String checkOrderDes;

    @ApiModelProperty(value = "0-未盘点，1-启动盘点，2-盘点结束")
    private Short status;

    @ApiModelProperty(value = "是否强制完成")
    private String enforced;

    @ApiModelProperty(value = "是否有计划")
    private Integer planned;

    @ApiModelProperty(value = "计划开始日期")
    private Date plannedDate;

    @ApiModelProperty(value = "创建人Id")
    private String createId;

    @ApiModelProperty(value = "创建人名称")
    private String createName;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "启动人Id")
    private String startId;

    @ApiModelProperty(value = "启动人名称")
    private String startName;

    @ApiModelProperty(value = "启动日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否删除")
    private Integer deleted;

    @ApiModelProperty(value = "机构id")
    private String orgId;

    @ApiModelProperty(value = "仓库编号")
    private String warehouseCode;
    @ApiModelProperty(value = "库区编号")
    private String locationCodesStr;
    @ApiModelProperty(value = "盘点类型")
    private Integer checkType;
    @ApiModelProperty(value = "是否条码化 0否1是")
    private Integer barcodeFlag;
}