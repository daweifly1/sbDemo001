package com.devi.tool.xgit.temp;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@TableComment(value = "单耗承包产出信息表")
@Data
@ToString
public class ConsumptionOutPut {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "单据编号")
    private String code;

    @ApiModelProperty(value = "协议号", required = true)
    private String agreementCode;
    @ApiModelProperty(value = "供应商ID", required = true)
    private String vendorId;
    @ApiModelProperty(value = "供应商名称")
    private String vendorName;

    @ApiModelProperty(value = "领料部门")
    private String applyDepartment;
    @ApiModelProperty(value = "领料部门Id")
    private String applyDepartmentId;
    @ApiModelProperty(value = "工段")
    private String section;

    @ApiModelProperty(value = "录入人员")
    private String recordUserName;

    @ApiModelProperty(value = "录入日期")
    private Date recordDate;

    @ApiModelProperty(value = "状态，0新建 ，1已生成计划")
    private Integer status;

    @ApiModelProperty(value = "创建人Id")
    private String createId;

    @ApiModelProperty(value = "创建人名称")
    private String createName;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "组织id")
    private String orgId;
}