package com.devi.oo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 抓取搜索数据规则
 */
@Data
@ToString
public class BabySearchGoodsRuleVO implements Serializable {
    private static final long serialVersionUID = -4450087707746811340L;
    private Long id;
    //类目id
    private Long categoryId;

    //年龄区间
    private Integer ageRange;

    //关键词
    private String keyWord;
    //排序
    private Long sort;

    //细分的类目id集合
    private List<Long> subCateList;
    //关联的属性集合
    private List<String> propertiesList;
}
