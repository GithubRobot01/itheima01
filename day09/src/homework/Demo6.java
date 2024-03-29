package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
现已知有一个文件（文件保存在模块目录下names.txt）里面存储了班级同学的姓名，
每一个姓名占一行。请编写程序实现随机获取到其中一个同学的姓名。（随机点名器）
 */
public class Demo6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("day09\\name.txt"));
        ArrayList<String> list=new ArrayList<>();
        String line;
        while ((line=br.readLine())!=null){
            list.add(line);
        }
        //System.out.println(list);
        br.close();
        String name=list.get(new Random().nextInt(list.size()));
        System.out.println(name+"恭喜你中奖了");
    }
}
