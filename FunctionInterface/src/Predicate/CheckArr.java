package Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;
/*
    练习：集合信息筛选
    数组当中有多条“姓名+性别”的信息如下，
    String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
    请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，
    需要同时满足两个条件：
        1. 必须为女生；
        2. 姓名为4个字。

    分析:
        1.有两个判断条件,所以需要使用两个Predicate接口,对条件进行判断
        2.必须同时满足两个条件,所以可以使用and方法连接两个判断条件
 */
public class CheckArr {
    public static boolean method(String s, Predicate<String> pre1,Predicate<String> pre2){
            return pre1.and(pre2).test(s);

    }

    public static void main(String[] args) {
        String[] arr={ "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        for (String s : arr) {
            boolean b=method(s,(String str)->{
                return str.split(",")[0].length()==4;
            },(String str)->{
                return str.split(",")[1].equals("女");
            });
            if (b){
                System.out.println(s);
            }
        }
    }
}
