package com.devi.tool.netease.model2;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BabySearchGoodsRuleItem implements Serializable {
    private static final long serialVersionUID = -4450087707746811340L;
    private Long id;
    //类目id
    private Long categoryId;
    private String categoryName;

    //关键词
    private String keyWord;

    //细分的类目id集合
    private Long subCate;
    //关联的属性集合
    private String property;
}
