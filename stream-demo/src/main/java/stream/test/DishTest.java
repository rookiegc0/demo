package stream.test;/**
 * @Auther: GC
 * @Date: 2023/04/19/19:12
 * @Description:
 */

import stream.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description TODO
 * @author GC
 * @date 2023/4/19 19:12
 * @version 1.0
 */
public class DishTest {
    public static void main(String[] args) {

        DishTest dishTest = new DishTest();
    }

    private List<String> beforeJava7(List<Dish> dishList){
        //new一个集合等会返回用的
        List<Dish> lowerkaluori = new ArrayList<>();
        //for循环遍历第一遍查出小于400卡路里的菜品
        for (Dish dish : dishList) {
            if(dish.getCalories()<400){
                lowerkaluori.add(dish);
            }
        }
        //对筛选出的菜肴进行排序
        Collections.sort(lowerkaluori,new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });
        //获取排序后的菜肴名字
        List<String> name = new ArrayList<>();
        for (Dish dish : lowerkaluori) {
            name.add(dish.getName());
        }
        return name;

    }
    ////不需要参数，返回值是5
    //() -> 5
    ////接收一个参数(数字类型)，返回其2倍的值
    //x -> 2 * x
    ////接受2个参数(数字)，并返回他们的差值
    //(x, y) -> x – y
    ////接收2个int型整数，返回他们的和
    //(int x, int y) -> x + y
    ////接收一个String对象，并在控制台打印，然后返回null
    //(String s) -> { System.out.println("输出: " + s); }
}
