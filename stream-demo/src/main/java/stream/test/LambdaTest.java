package stream.test;/**
 * @Auther: GC
 * @Date: 2023/04/20/22:18
 * @Description:
 */

import java.util.function.IntBinaryOperator;

/**
 * @description TODO
 * @author GC
 * @date 2023/4/20 22:18
 * @version 1.0
 */
public class LambdaTest {
 public static void main(String[] args) {

  LambdaTest lambdaTest = new LambdaTest();

  //String常用的一些API
  String str = "'Hello','World'\n";
  String str1 = "'taobao'\n";
  System.out.println(str);
  System.out.println(str1);

    //1.获取字符串长度
  int length = str.length();
  //2.获取指定位置的字符
  char c = str.charAt(0);
  //3.比较两个字符串是否相等
  boolean equals = str.equals(str1);
    //4.比较两个字符串是否相等，忽略大小写
  boolean b = str.equalsIgnoreCase(str1);
  //将字符串转换为大写
  String s = str.toUpperCase();
  //将字符串转换为小写
    String s1 = str.toLowerCase();
    //5.截取字符串
  String substring = str.substring(0, 2);
  //6.查找指定字符串在当前字符串中第一次出现的位置
    int i = str.indexOf("l");
    //替换字符串中的字符,只替换第一个，replaceAll替换所有
  String replace = str.replace('l', 'k');
  String s2 = str.replaceAll("l", "k");
  //7.去除字符串两端的空格
  //拼接字符串
    String s3 = str.concat(str1);
  System.out.println(s3);

 }
}
