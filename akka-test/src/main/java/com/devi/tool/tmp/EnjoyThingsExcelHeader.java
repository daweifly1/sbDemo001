package com.devi.tool.tmp;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class EnjoyThingsExcelHeader {


    public static String getExcelHeader(String oldKey) {
        Map<String, String> map = Maps.newHashMap();
        map.put("商品ID", "goodsId");
        map.put("商品id", "goodsId");
        map.put("内容标题", "contentTitle");
        map.put("赏物推荐语1", "enjoyRecommend1");
        map.put("赏物推荐语2", "enjoyRecommend2");
        map.put("赏物推荐语3", "enjoyRecommend3");
        map.put("赏物推荐语4", "enjoyRecommend4");
        map.put("赏物推荐语5", "enjoyRecommend5");
        map.put("赏物图片", "enjoyRecommendImg");
        map.put("达人推荐", "talentRecommend");
        map.put("达人推荐图片", "talentRecommendImg");
        map.put("达人名", "talentId");
        String newKey = map.get(oldKey);
        //对表头做额外兼容处理
        if (StringUtils.isBlank(newKey)) {
            if (oldKey.startsWith("达人名")) {
                return "talentId";
            } else if (oldKey.startsWith("达人账号")) {
                return "talentId";
            } else if (oldKey.startsWith("达人推荐图片")) {
                return "talentRecommendImg";
            } else if (oldKey.startsWith("文章标题")) {
                return "contentTitle";
            }
        }
        if (StringUtils.isBlank(newKey)) {
            throw new RuntimeException("上传数据失败,未知表头，请按照模板填写上传！");
        }
        return newKey;
    }
}