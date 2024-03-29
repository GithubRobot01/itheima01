package Exception_;

import java.io.IOException;

/*finally代码块 格式:
        try{
        可能产生异常的代码
        }catch(定义一个异常的变量,用来接收try中抛出的异常对象){
        异常的处理逻辑,产生异常对象之后,怎么处理异常对象
        一般在工作中,会把异常的信息记录到一个日志中
        }
        ...
        catch(异常类名 变量名){
        }finally{
        无论是否出现异常都会执行
        }
        注意:finally不能单独使用,必须和try一起使用
        finally一般用于资源释放(资源回收),无论程序是否出现异常,最后都要资源释放(IO)
*/
public class FinallyDemo {
    public static void main(String[] args) {
        try {
            readFile("C:\\a.txt");
        } catch (IOException e) { //try中抛出什么异常对象,catch就定义什么异常变量,用来接收这个异常对象
            e.printStackTrace();
        }finally {
            //无论是否出现异常,都会执行
            System.out.println("资源释放!");
        }
        System.out.println("try...catch之后!");
    }
    public static void readFile (String fileName) throws IOException {
        if (!fileName.endsWith(".txt")){
            throw new IOException("文件后缀错误!");
        }
        //出现异常后不会执行以下语句
        System.out.println("读取中...");
    }
}
