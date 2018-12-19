package com.devi.tool.netease.freemarker;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by hzchendawei on 2018/4/4.
 */
@Data
@ToString
public class MapperBean {
    private String namespace;
    private String type;
    private String voType;

    private String beanName;
    //首字母小写
    private String fistLowerBeanName;
    private String packageName;

    private String tableName;
    private String tableComment;

    private String tableTsName;


    private List<ModelProperties> propertiesList;

    @Data
    @ToString
    public static class ModelProperties {
        private String column;

        private String property;

        private String jdbcType;

        private String javaType;

        private String comment;

        private Integer length;

        private boolean nullAble;

        boolean required;
    }
}
