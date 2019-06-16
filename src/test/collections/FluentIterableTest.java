package test.collections;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 *FluentIterable的测试
 */
public class FluentIterableTest {
    private ArrayList<String> list = Lists.newArrayList("xcy", "guava", "test");
    /**
     *往集合添加元素和集合
     */
    @Test
    public void test(){
        FluentIterable<String> from = FluentIterable.from(list);
        //过滤掉list集合中为空切长度小于等于3的
        FluentIterable<String> filter = from.filter(e -> e != null && e.length() > 3);
        //集合中添加新的集合
        ArrayList<String> list1 = Lists.newArrayList("lj");
        FluentIterable<String> append = from.append(list1);
        append.forEach(System.out ::println);
        //往集合中添加新得元素
        FluentIterable<String> append1 = from.append("hello");
        append1.forEach(System.out :: println);
    }

    /**
     * 获得集合中满足条件的元素
     */
    @Test
    public void test1(){
        ArrayList<String> list = Lists.newArrayList("xcy", "guava", "test");
        FluentIterable<String> from = FluentIterable.from(list);
        //判断所有元素是否长度大于3 且不为空
        boolean b = from.allMatch(e -> e != null && e.length() > 3);
        //判断是否有一个元素长度大于3 且不为空
        boolean b1 = from.anyMatch(e -> e != null && e.length() > 3);
        System.out.println(b);
        System.out.println(b1);
        //找到第一个满足条件的元素
        Optional<String> optional = from.firstMatch((String s) -> s != null && s.length() > 3);
        System.out.println(optional.get());
        //获取集合的第一个元素
        Optional<String> optional1 = from.first();
        //获取集合的最后一个元素
        Optional<String> optional2 = from.last();
        System.out.println(optional1.get()+ "" + optional2.get());
    }

    /**
     * 获取限制长度内的集合
     */
    @Test
    public void test2(){
        ArrayList<String> list = Lists.newArrayList("xcy", "guava", "test");
        FluentIterable<String> from = FluentIterable.from(list);
        //获取限制长度内的集合
        FluentIterable<String> limit = from.limit(2);
        limit.forEach(System.out :: println);
    }
    /**
     *复制一个集合的元素到另一个集合去
     */
    @Test
    public void test3(){
        ArrayList<String> list = Lists.newArrayList("xcy", "guava", "test");
        ArrayList<String> list1 = Lists.newArrayList( "lj");
        FluentIterable<String> from = FluentIterable.from(list);
        //复制list的元素到list1的集合去，注意list1的元素不会被覆盖
        ArrayList<String> list2 = from.copyInto(list1);
        list2.forEach(System.out ::println);
    }

    /**
     * 无限循环一个集合，可配合limit方法来用
     */
    @Test
    public void test4(){
        ArrayList<String> list = Lists.newArrayList("xcy", "guava", "test");
        FluentIterable<String> from = FluentIterable.from(list);
        //cycle是一个无限循环了list集合的集合。配合limit使用就是循环到长度为20的集合
        FluentIterable<String> cycle = from.cycle().limit(20);
        cycle.forEach(System.out :: println);
    }

    /**
     * 把一个集合中的每一个元素替换为另一个集合
     * 即有集合a，b
     * 可以把a中的每一个元素替换为b
     */
     @Test
    public void test5(){
         ArrayList<String> list = Lists.newArrayList("xcy", "guava", "test");
         FluentIterable<String> from = FluentIterable.from(list);
         List<Integer> list1 = Lists.newArrayList(1,2);
         //把list中的每一个元素替换为list1
         FluentIterable<Integer> strings = from.transformAndConcat(e -> list1);
         strings.forEach(System.out ::println);
     }

}
