/**
 * @Auther: GC
 * @Date: 2023/05/24/22:42
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fastjson.User;
import com.fastjson.UserGroup;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GC
 * @version 1.0
 * @description TODO
 * @date 2023/5/24 22:42
 */
@SpringBootTest
public class JsonTest {

    /***
     * @description java类到字符串
     *
     * @return
     * @author
     * @date
    */
    @Test
    public void objToJson() {
        //简单对象转换
        User user = new User();
        user.setName("root");
        user.setPassword("123456");
        //把对象转换成json
        String toJSONString = JSON.toJSONString(user);
        System.out.println(toJSONString);

        User user1 = new User();
        user1.setName("gaochen");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setName("xiaosong");
        user2.setPassword("123456");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        String s = JSON.toJSONString(users);
        System.out.println(s+"json数组");

        //复杂java类转换对象
        UserGroup userGroup = new UserGroup();
        userGroup.setUsers(users);
        userGroup.setName("集合数组");
        String s1 = JSON.toJSONString(userGroup);
        System.out.println(s1);
    }

    /***
     * @description json字符串转换为java类
     * @param null
     * @return
     * @author
     * @date
    */
    @Test
    public void jsonToobj(){

        //json字符串转换简单对象
        String jsonStr1 = "{'password':'123456','username':'ggf'}";
        User user = JSON.parseObject(jsonStr1, User.class);
        System.out.println(user);

        //json字符串转换list对象
        String jsonStr2 = "[{'password':'123123','name':'zhangsan'},{'password':'321321','name':'lisi'}]";
        List<User> users = JSON.parseArray(jsonStr2, User.class);
        System.out.println(users);

        //json字符串转换复杂对象
        String jsonStr3 = "{'name':'userGroup','users':[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]}";
        UserGroup userGroup = JSON.parseObject(jsonStr3, UserGroup.class);
        System.out.println(userGroup);


    }

    /***
     * @description TODO
     * @param null
     * @return 对json字符串的操作
     * @author
     * @date
    */
    @Test
    public void operateJson(){
        String jsonStr1 = "{'password':'123456','username':'ggf'}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr1);
        Object username = jsonObject.get("username");
        System.out.println(username);
        System.out.println(jsonObject.get("password"));
    }

}
