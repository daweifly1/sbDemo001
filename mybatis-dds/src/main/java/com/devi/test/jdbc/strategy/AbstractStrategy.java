package com.devi.test.jdbc.strategy;


import com.devi.test.jdbc.enums.DynamicDataSourceGlobal;

import javax.sql.DataSource;

public abstract class AbstractStrategy implements Strategy {

    public String select(java.util.List<DataSource> slaves, DataSource master) {
        if (slaves == null || slaves.isEmpty())
            return DynamicDataSourceGlobal.WRITE.name();
        if (slaves.size() == 1)
            return DynamicDataSourceGlobal.READ.name() + "_0";
        return doSelect(slaves, master);
    }

    /**
     * @param slaves, master
     * @return String
     * @throws
     * @Description: 读的数据源为多个的时候
     * @Title doSelect
     * @Author lv bin
     * @Date 2016/11/7 9:29
     */
    protected abstract String doSelect(java.util.List<DataSource> slaves, DataSource master);
}