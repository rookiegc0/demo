package stream.model;/**
 * @Auther: GC
 * @Date: 2023/04/19/19:10
 * @Description:
 */

import lombok.Data;

import java.lang.reflect.Type;

/**
 * @description TODO
 * @author GC
 * @date 2023/4/19 19:10
 * @version 1.0
 */
@Data
public class Dish {
 private String name;
 private boolean vegetarian;
 private int calories;
 private Type type;
}
