package com.devi.oo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 宝贝年龄段对应的属性信息
 */
@Data
@ToString
public class BabyAgePropVO implements Serializable {
    private static final long serialVersionUID = -4450087707746811340L;
    Map<Integer, List<String>> props;

    //性别的属性配置
    Map<Integer, List<String>> genderProps;


    public List<String> getProp(Integer ageRange) {
        List<String> list = new ArrayList<>();
        if (null != props && null != props.get(ageRange) && props.get(ageRange).size() > 0) {
            list.addAll(props.get(ageRange));
        }
        return list;
    }


    public List<String> getGenderProp(Integer gender) {
        List<String> list = new ArrayList<>();
        if (null != genderProps && null != genderProps.get(gender) && genderProps.get(gender).size() > 0) {
            list.addAll(genderProps.get(gender));
        }
        return list;
    }
}
