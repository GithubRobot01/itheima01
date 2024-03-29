package Exception_;
/*
throw关键字作用:可以使用throw关键字在指定的方法中抛出异常
使用格式:throw new xxxException("异常产生的原因")
注意:1.throw关键字必须写在方法的内部
2.throw关键字后边new的对象必须是Exception或者它的子类对象
3.throw关键字抛出指定的异常对象,我们就必须处理这个异常对象
    throw关键字后边创建的是RuntimeException或者它的子类对象,我们可以不处理,默认交给JVM处理(打印异常对象,中断程序)
    throw关键字后边创建的是编译异常,我们就必须出来这个异常,要么throws,要么try...catch
 */
public class ThrowDemo {
    //以后我们首先必须对方法传递过来的参数进行合法性校验
    //如果参数不合法,那么我们就必须使用抛出异常的方式,告知方法的调用者,传递的参数有问题
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int e=getElement(arr,3);
    }

    private static int getElement(int[] arr, int i) {
        if(arr==null){
            //NullPointerException是一个运行期异常,我们不用处理,默认交给JVM处理
            throw new NullPointerException("传递的参数为空");
        }
        if (i<0||i>arr.length){
            throw new ArrayIndexOutOfBoundsException("传递的索引超过数组的使用范围");
        }
        return arr[i];
    }
}
