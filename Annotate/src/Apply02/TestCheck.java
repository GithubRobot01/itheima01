package Apply02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 *
 * 当主方法执行后,会自动执行被检测的所有方法(加check注解的方法),判断方法是否有异常,并记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        ///1.创建对象
        Calculator c=new Calculator();
        //2.获取字节码文件对象
        Class<? extends Calculator> clazz= c.getClass();

        //3.获取所有方法
        Method[] methods = clazz.getMethods();

        int number=0; //记录异常次数
        BufferedWriter bw=new BufferedWriter(new FileWriter("Annotate\\bug.txt"));

        for (Method method : methods) {
            //4.判断方法上是否有check注解
            if (method.isAnnotationPresent(Check.class)){
                //有则执行方法
                try {
                    method.invoke(c);
                }catch (Exception e) {
                    number++;
                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称:"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因:"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现"+number+"次异常");
        bw.flush();
        bw.close();

    }
}
