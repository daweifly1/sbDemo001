package com.devi.test;

import com.devi.test.fastjson.FastJsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class CommonTest {

    public static void main(String[] args) {
        List<Map<String, Object>> msgList = new ArrayList<>();
        for (int i=0;i<10;i++) {
            Map<String, Object> msg = new HashMap<>();
            msg.put("id",i+0L);
            msg.put("goodsId", i+1027L);
            //是否是删除
            msg.put("delete", false);
            msgList.add(msg);
        }
        String msgJSON = FastJsonUtil.toJSONString(msgList);
        System.out.println(msgJSON);
    }
}
