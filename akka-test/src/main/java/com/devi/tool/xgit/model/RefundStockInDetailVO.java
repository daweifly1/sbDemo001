package com.devi.tool.xgit.model;

import com.devi.tool.xgit.annotation.TableComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 入库行记录维度记录，供前台选择
 */
@TableComment(value = "dd")
@Data
@ToString
public class RefundStockInDetailVO implements Serializable {
    private String id;

    @ApiModelProperty(value = "合同号")
    private String contractNo;
    @ApiModelProperty(value = "erp接收号")
    private String erpNo;

    @ApiModelProperty(value = "物料编码")
    private String materialCode;

    @ApiModelProperty(value = "已入库数量")
    private BigDecimal amountIn;

    @ApiModelProperty(value = "入库单号")
    private String billNo;

    @ApiModelProperty(value = "ERP入库的交易ID")
    private String erpDeliveryTrxId;

    //统计而来
    @ApiModelProperty(value = "已退货数量")
    private BigDecimal amountOut;

    @ApiModelProperty(value = "是否条码化(0条码，1非条码)")
    private Integer barcodeFlag;

    @ApiModelProperty(value = "ERP同步标识（0未同步  1同步中 2 成功 3失败）,前端无需关注")
    private Integer erpSyncFlag;

    @ApiModelProperty(value = "制单时间，开始时间")
    private Date startCreateDate;

    @ApiModelProperty(value = "制单时间，时间")
    private Date endCreateDate;

    @ApiModelProperty(value = "储位")
    private String locationCode;
}
