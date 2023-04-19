package stream.test;/**
 * @Auther: GC
 * @Date: 2023/04/19/13:02
 * @Description:
 */

import stream.model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description TODO
 * @author GC
 * @date 2023/4/19 13:02
 * @version 1.0
 */
public class FilterTest {
     public static void main(String[] args) {
         List<Integer> number = Arrays.asList(2, 4, 5, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
         List<String> name = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
         String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
         //筛选出Integer中大于7的元素，并且打印出来
         //list.stream().filter(x -> x > 7).forEach(System.out::println);
         //筛选出员工中工资高于2000的人，并且形成新的集合。
         ArrayList<Person> personList = new ArrayList<>();
         personList.add(new Person("Tom", 8900, 23, "male", "New York"));
         personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
         personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
         personList.add(new Person("Anni", 8200, 24, "female", "New York"));
         personList.add(new Person("Owen", 9500, 25, "male", "New York"));
         personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

         List<String> stringList = personList.stream().filter(x -> x.getSalary() > 2000).map(x -> x.getName()).collect(Collectors.toList());
         //System.out.println("薪资高于2000的人有：" + stringList);

         //聚合函数(max,min,count)
         //获取String集合中最长的元素
         Optional<String> max = name.stream().max(Comparator.comparing(String::length));
         String s = max.get();
         //System.out.println("最长的元素是：" + s);

         //获取Integer集合中最大的值
         Optional<Integer> integer = number.stream().max(Integer::compareTo);
         Integer integer1 = integer.get();
         //System.out.println("最大的值是：" + integer1);

         //获取员工工资最大的值
         Optional<Person> max1 = personList.stream().max(Comparator.comparing(Person::getSalary));
         //System.out.println("员工薪资最大值:" + max1.get().getSalary());

         //计算Integer集合中大于6的个数，注意是个数
         long count = number.stream().filter(x -> x > 6).count();
         //System.out.println("大于6的个数是：" + count);

         //映射（map/flatMap）
         List<String> strings = Arrays.asList(strArr);
         //for循环遍历每个strings元素，并且转换成大写，最后形成新集合
         for (String string : strings) {
             String toUpperCase = string.toUpperCase();
         }
         for (String s1 : strings) {
             String toUpperCase = s1.toUpperCase();
             //System.out.println(toUpperCase);
         }
         List<String> collect = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
         //System.out.println(collect);


         //整数数组每个元素+3
         List<Integer> collect1 = number.stream().map(x -> x + 3).collect(Collectors.toList());
         //System.out.println(collect1);

         //员工薪资+1000
         List<Person> collect2 = personList.stream().map(person -> {
             person.setSalary(person.getSalary() + 1000);
             return person;
         }).collect(Collectors.toList());
            //System.out.println(collect2);

         //将两个字符数组合并成一个新的字符数组
         String[] strArr1 = { "H,e,l,l,o", "World" };
         //System.out.println(strArr1);
         List<String> strings1 = Arrays.asList(strArr1);
         System.out.println(strings1);
         List<String> collect3 = strings1.stream().flatMap(x -> {
             String[] split = x.split(",");
             return Arrays.stream(split);
         }).collect(Collectors.toList());
         //System.out.println(collect3);

         //maptoint可以求最大值最小值平均值
         int asInt = number.stream().mapToInt(Integer::intValue).max().getAsInt();
         int asInt1 = number.stream().mapToInt(Integer::intValue).min().getAsInt();
         double asDouble = number.stream().mapToInt(Integer::intValue).average().getAsDouble();
         System.out.println("最大值是：" + asInt + "最小值是：" + asInt1 + "平均值是：" + asDouble);

         //归约 能实现把一个流缩减成一个值，能实现对集合整体求和，求乘积和求最值的操作
         Optional<Integer> reduce = number.stream().reduce((x, y) -> x + y);
         Integer integer2 = reduce.get();
         Optional<Integer> reduce1 = number.stream().reduce(Integer::sum);
         Integer integer3 = reduce1.get();
         Optional<Integer> reduceMax = number.stream().reduce(Integer::max);
         Integer integer4 = reduceMax.get();
         Optional<Integer> reduceMin = number.stream().reduce(Integer::min);
         Integer integer5 = reduceMin.get();
         Optional<Integer> reduceMul = number.stream().reduce((x,y) -> x * y);
         Integer integer6 = reduceMul.get();

         //求所有工资之和
         Integer integer7 = personList.stream().map(Person::getSalary).reduce(Integer::sum).get();
         //System.out.println("所有工资之和是：" + integer7);


         //collect的使用，也就是统计功能的使用
            //统计员工的个数
         Long collect4 = personList.stream().collect(Collectors.counting());
         //员工平均工资
         Double aDouble = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
         //员工工资之和
         DoubleSummaryStatistics collect5 = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
         //System.out.println(collect5.getSum());
            //最高工资
         Optional<Person> collect6 = personList.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getSalary)));
         //System.out.println(collect6.get().getSalary());
            //最低工资
         Optional<Person> low = personList.stream().collect(Collectors.minBy(Comparator.comparing(Person::getSalary)));
         //System.out.println(low.get().getSalary());
            //工资之和
            Integer collect7 = personList.stream().collect(Collectors.summingInt(Person::getSalary));
         //System.out.println(collect7);
            //工资之和

         //分组方法的使用
         //将员工按薪资是否高于8000分为两部分，将员工按性别和地区分组
         Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
         //将员工按照性别进行分组
         Map<String, List<Person>> collect8 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
         //将员工先按照性别分组，再按照地区分组
         Map<String, Map<String, List<Person>>> collect9 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
            //将员工按照性别分组，统计每组员工的个数
         Map<String, Long> collect10 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting()));
         //System.out.println("员工按薪资是否大于8000分组情况：" + part);
         //System.out.println("员工按性别分组情况：" + collect8);
         //System.out.println("员工按性别和地区分组情况：" + collect9);
         //System.out.println("员工按性别分组情况：" + collect10);

         //结合(joining)方法的使用
         String collect11 = personList.stream().map(p -> p.getName()).collect(Collectors.joining("&"));
         System.out.println("员工姓名：" + collect11);
         List<String> strings2 = Arrays.asList("a", "b", "c");
         String collect12 = strings2.stream().collect(Collectors.joining("&"));
         System.out.println("字符串拼接：" + collect12);

         //排序sorted
         //有两种形式，一种是自然排序，一种是定制排序
         //按照工资升序进行排序
         List<String> collect13 = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
         System.out.println("按照工资升序排序：" + collect13);
         //按照工资倒序进行排序
         List<String> collect14 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
         System.out.println("按照工资倒序排序：" + collect14);

         //多种排序方式 先按照工资排序，再按照年龄排序
         List<String> collect15 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
         System.out.println("先按照工资排序，再按照年龄排序：" + collect15);

         //先按照工资排序，再按照年龄倒序排序
         List<String> collect16 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge).reversed()).map(Person::getName).collect(Collectors.toList());
         System.out.println("先按照工资排序，再按照年龄倒序排序：" + collect16);

         //提取，组合
         String[] arr1 = { "a", "b", "c", "d" };
         String[] arr2 = { "d", "e", "f", "g" };

         Stream<String> arr11 = Stream.of(arr1);
         Stream<String> arr22 = Stream.of(arr2);
         //concat方法将两个流合并成一个流然后distinct去重
         Stream<String> distinct = Stream.concat(arr11, arr22).distinct();
         System.out.println("提取，组合：" + distinct.collect(Collectors.toList()));
         //limit限制从流中获得前n个数据
         List<String> collect17 = Stream.of(arr1).limit(2).collect(Collectors.toList());
         System.out.println("limit限制从流中获得前n个数据：" + collect17);
         Stream.iterate(0, x -> x + 2).limit(10).forEach(System.out::println);
         System.out.println("====================================");
         //跳过前n个数据
         Stream<Integer> limit = number.stream().skip(1).limit(5);
         limit.collect(Collectors.toList()).forEach(System.out::println);

     }

}
