package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 * MultiMap
 */
public class MultiMapTest {
    @Test
    public void test(){
        Map map1 = new HashMap();
        //创建一个可以存放重复key的map
        LinkedListMultimap<String, String> map = LinkedListMultimap.create();
        map.put("1","2");
        map.put("1","3");
        List<String> list = map.get("1");
        System.out.println(list);
    }
}
