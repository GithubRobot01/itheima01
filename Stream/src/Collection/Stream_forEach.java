package Collection;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_forEach
    void forEach(Consumer<? super T> action);
    该方法接收一个Consumer接口函数，会将每一个流元素交给该函数进行处理。
    Consumer接口是一个消费型的函数式接口,可以传递Lambda表达式,消费数据

    简单记:
        forEach方法,用来遍历流中的数据
        是一个终结方法,遍历之后就不能继续调用Stream流中的其他方法
 */
public class Stream_forEach {
    public static void main(String[] args) {
        //获取stream流
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六");
        stream.forEach(name-> System.out.println(name));
    }
}
