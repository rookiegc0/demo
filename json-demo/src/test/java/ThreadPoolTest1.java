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
 * @date
 */
@SpringBootTest
public class ThreadPoolTest1 {

    @Test
    public void operateJson() {
        String jsonStr1 = "{'password':'123456','username':'ggf'}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr1);
        Object username = jsonObject.get("username");
        System.out.println(username);
        System.out.println(jsonObject.get("password"));
    }

}
