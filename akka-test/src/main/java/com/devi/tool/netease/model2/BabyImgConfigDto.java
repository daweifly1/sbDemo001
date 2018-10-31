package com.devi.tool.netease.model2;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class BabyImgConfigDto implements Serializable {
    private String barCode;
    private String inboundOrder;
    private Integer inboundType = 0;
    private Integer frozen;
    private String oldLocationCode;
    private Integer rowNo;
    private String businessLineId;
    /**
     * 是否协议类型 0否1是
     */
    private Integer agreementFlag;
    /**
     * 协议号
     */
    private String agreementCode;
    private String id;
    private String businessSingle;
    private String businessOrder;
    private String materialNo;
    private String materialName;
    private String materialType;
    private String warehouseCode;
    private String areaCode;
    private String locationCode;
    private BigDecimal amount;
    private BigDecimal realAmount;
    private String unit;
    private String model;
    private String note;
    private Integer status = 0;
    private String createrId;
    private String createrName;
    private Date createDate;

}
