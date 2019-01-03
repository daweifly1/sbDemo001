package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 单耗承包--协议  VO类
 */
@TableComment(value = "单耗承包产出信息表")
@Data
@ToString
public class AgreementInfoVO implements Serializable {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty(value = "协议号", required = true)
    private String agreementCode;
    @ApiModelProperty(value = "供应商ID", required = true)
    private String vendorId;
    @ApiModelProperty(value = "供应商名称")
    private String vendorName;
//    @ApiModelProperty(value = "领料部门")
//    private String applyDepartment;
//    @ApiModelProperty(value = "领料部门Id")
//    private String applyDepartmentId;
//    @ApiModelProperty(value = "工段")
//    private String section;
//    @ApiModelProperty(value = "录入人员")
//    private String recordUserName;
//    @ApiModelProperty(value = "录入日期")
}
