/**
 *
 */
package com.devi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * @author 盛宇伟
 *         项目名称：BatchImportFace
 *         类名称：TestCreatePerson
 *         类描述：
 *         创建时间：2018年3月20日 上午9:23:34
 *         修改时间：2018年3月20日 上午9:23:34
 *         修改备注：
 */
public class TestCreatePerson {
    public static void main(String[] args) {
        HashMap<String, String> mapParm = new HashMap<String, String>();
        mapParm.put("app-id", "test");
        mapParm.put("app-key", "test");
        RestHttpUtil wsUtil = new RestHttpUtil("112.2.1.50", 8001, mapParm);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> requireMap = new HashMap<String, String>();
        requireMap.put("group-name", "兄弟组"+(new Random(5).nextInt()));
        String returnJson = wsUtil.doPost("arges-service/api/group/create", requireMap);
        try {
//            GroupCreate groupCreate = mapper.readValue(returnJson, GroupCreate.class);

            GroupCreate groupCreate=new GroupCreate();
            groupCreate.setGroupId(25);
            //到此，组创建完毕，
            requireMap.clear();
            requireMap.put("person-name", "测试人员222");
            requireMap.put("group-ids", String.valueOf(groupCreate.getGroupId()));
            String personCreateJson = wsUtil.doPost("arges-service/api/person/create", requireMap);
            Person person = mapper.readValue(personCreateJson, Person.class);
            //这里，人创建完毕，根据这个人来上传相关的图片
            requireMap.clear();
            requireMap.put("person-id", String.valueOf(person.getPersonId()));
            //这里读取本地的图片，来上传
            FileInputStream fileIn = new FileInputStream("D://cc.jpg");
            BASE64Encoder encoder = new BASE64Encoder();
            byte[] imageData = new byte[fileIn.available()];
            fileIn.read(imageData);
            String myImageData = "data:image/jpeg;base64," + encoder.encode(imageData);
            fileIn.close();
            requireMap.put("image-data", myImageData);
            returnJson = wsUtil.doPost("arges-service/api/person/append-face", requireMap);
            System.out.println(returnJson);
            //这里就注册成功了。查询在某一个组内的用户，详见API文档
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

class GroupCreate {
    private long groupId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}

class Person {
    private long personId;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }


}