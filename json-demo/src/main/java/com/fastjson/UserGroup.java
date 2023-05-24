package com.fastjson;/**
 * @Auther: GC
 * @Date: 2023/05/24/22:40
 * @Description:
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description TODO
 * @author GC
 * @date 2023/5/24 22:40
 * @version 1.0
 */
@Data
public class UserGroup {

    private String name;
    private List<User> users = new ArrayList<>();

}
