package stream.test;/**
 * @Auther: GC
 * @Date: 2023/04/19/13:02
 * @Description:
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @description TODO
 * @author GC
 * @date 2023/4/19 13:02
 * @version 1.0
 */
public class MyTest {
     public static void main(String[] args) {

         //遍历匹配（foreach,find,match）
         //先搞出一个list
         List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
         //遍历输出符合条件的元素
         list.stream().filter(x -> x > 6).forEach(System.out::println);
         //匹配第一个
         Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
         Integer integer = first.get();
         //匹配任意一个
         Optional<Integer> any = list.stream().filter(x -> x > 6).findAny();
         Integer anyOne = any.get();
         //是否包含符合特定条件的元素
         boolean anyMatch = list.stream().anyMatch(x -> x < 0);
         System.out.println("是否存在小于0的值：" + anyMatch);
         System.out.println("是否存在大于7的值" + anyOne);
         System.out.println("大于6的第一个人是谁" + integer);
         System.out.println("====================================");

         //筛选操作filter
         //筛选出Integer中大于7的元素，并且打印出来

     }
}
