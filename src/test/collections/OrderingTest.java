package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 *
 */
public class OrderingTest {
    @Test
    public void test(){
        List<String> list = Arrays.asList("1", "3", "4", "5",null);
        //list排序，null值放最前
        Collections.sort(list,Ordering.natural().nullsFirst());
        //list排序，null值放最后
        Collections.sort(list,Ordering.natural().nullsLast());
        List<String> list1 = Arrays.asList("1", "3", "4", "5");
        //list排序，自然顺序
        Collections.sort(list1,Ordering.natural());
        //list排序，自然顺序倒叙
        Collections.sort(list1,Ordering.natural().reverse());
    }
}
