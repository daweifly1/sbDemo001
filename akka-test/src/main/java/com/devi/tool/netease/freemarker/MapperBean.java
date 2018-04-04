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
    private String beanName;
    private String packageName;

    private String tableName;

    private List<ModelProperties> propertiesList;

    public static class ModelProperties {
        private String column;

        private String property;

        private String jdbcType;

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getJdbcType() {
            return jdbcType;
        }

        public void setJdbcType(String jdbcType) {
            this.jdbcType = jdbcType;
        }
    }
}
