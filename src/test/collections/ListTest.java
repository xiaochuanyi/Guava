package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 * List
 */
public class ListTest {
    /**
     * 把集合中的元素转换为大写
     */
    @Test
    public void test(){
        ArrayList<String> list = Lists.newArrayList("xcy", "java");
        //把list集合中的元素转换为大写
        List<String> transform = Lists.transform(list, e -> e.toUpperCase());
        transform.forEach((String i) -> System.out.println(i));
    }
    @Test
    public void test1(){
        //构建一个初始化大小为10的list
        ArrayList<String> list = Lists.newArrayListWithCapacity(10);
    }
    @Test
    public void test2(){
        //反转这个集合
        ArrayList<String> list = Lists.newArrayList("xcy", "java");
        List<String> reverse = Lists.reverse(list);
        System.out.println(reverse);
    }
    @Test
    public void test3(){
        ArrayList<String> list = Lists.newArrayList("xcy", "test", "hello", "guava");
        //按大小分区
        List<List<String>> partition = Lists.partition(list,2);
        System.out.println(partition);

    }

}
