package com.devi.tool.tmp;

import com.devi.tool.util.excel.ExcelUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by hzchendawei on 2018/4/16.
 */
public class ExcelTmp {

    public static void main(String[] args) {
//        ExcelUtil.
        try {
            List<Map<String, Object>> list = queryExcelData(new File("F://tmp/bbb.xlsx"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static List<Map<String, Object>> queryExcelData(File file) throws IOException {
        List<Map<String, Object>> list = ExcelUtil.uploadExcelToList(file, new ExcelUtil.IKeyGen() {
            @Override
            public String genNewKey(String oldKey) {
                return EnjoyThingsExcelHeader.getExcelHeader(oldKey);
            }
        });
        return list;
    }
}
