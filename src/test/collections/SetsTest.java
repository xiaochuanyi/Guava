package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 * Set集合
 */
public class SetsTest {
    /**
     * 创建一个set
     */
    @Test
    public void test(){
        HashSet<Integer> set = Sets.newHashSet(1, 2, 3);
        System.out.println(set);
        //创建一个set，会自动去掉list中重复元素
        ArrayList<Integer> list = Lists.newArrayList(1, 1, 2, 3, 3);
        HashSet<Integer> set1 = Sets.newHashSet(list);
        System.out.println(set1);
    }

    /**
     * 过滤掉set不满足条件的的元素
     */
    @Test
    public void test1(){
        HashSet<Integer> set = Sets.newHashSet(1, 2, 3);
        Set<Integer> filter = Sets.filter(set, e -> e > 2);
        System.out.println(filter);
    }
}
