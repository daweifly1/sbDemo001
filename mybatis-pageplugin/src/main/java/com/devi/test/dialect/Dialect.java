package com.devi.test.dialect;


import com.devi.test.pagination.Page;

public interface Dialect {

    String pageSql(String sql, Page page);
}
