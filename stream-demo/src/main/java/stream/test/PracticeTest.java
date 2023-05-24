package stream.test;/**
 * @Auther: GC
 * @Date: 2023/05/17/21:16
 * @Description:
 */

import stream.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description TODO
 * @author GC
 * @date 2023/5/17 21:16
 * @version 1.0
 */
public class PracticeTest {
    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(2, 4, 5, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<String> name = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };

        //筛选出数组当中大于7的数字，筛选出来,筛选用filter
        List<Integer> collect = number.stream().filter(x -> x > 7).collect(Collectors.toList());

        //筛选出员工工资高于2000的人，并且形成新的集合
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> person = personList.stream().filter(x -> x.getSalary() > 2000).map(Person::getName).collect(Collectors.toList());

        //聚合函数（max,min,count）
        //获取string集合中最长的元素
        String longEst = name.stream().max(Comparator.comparing(String::length)).get();

        //获取Integer中集合最最大的值
        Integer integer = number.stream().max(Integer::compareTo).get();

        //获取员工工资最大的值
        Person person1 = personList.stream().max(Comparator.comparing(Person::getSalary)).get();

        //计算Integer集合中大于6的个数，注意是个数
        long count = number.stream().filter(s -> s > 6).count();

        //映射map的用法
        List<String> strings = Arrays.asList(strArr);
        //for循环遍历每个元素，把他们转换成大写，最后形成新的集合
        List<String> list = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        //规约 实现把流缩减成为一个值，实现整体求和，求乘积求最值的操作
        Integer integer1 = number.stream().reduce(Integer::sum).get();
        Integer integer2 = number.stream().reduce((x, y) -> x * y).get();


    }
}
