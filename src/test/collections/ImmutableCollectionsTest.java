package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 * ImmutableCollections
 */
public class ImmutableCollectionsTest {
    @Test
    public void test(){
        //创建一个内容不可变的List
        ImmutableList<Integer> of = ImmutableList.of(1, 2, 3);
        System.out.println(of);
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        //创建一个内容不可变的List
        ImmutableList<Integer> list1 = ImmutableList.copyOf(list);
        System.out.println(list1);
        //创建一个内容不可变的List
        ImmutableList<Integer> build = ImmutableList.<Integer>builder()
                .add(1).add(2, 3)
                .addAll(list).build();
        System.out.println(build);
    }
}
