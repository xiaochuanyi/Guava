package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 * Map集合
 */
public class MapTest {
    @Test
    public void test(){
        ArrayList<String> valueList = Lists.newArrayList("1", "2", "3");
        //创建一个map，value的值依次为valueList的元素,key为e+key,此map不可变
        ImmutableMap<String, String> map = Maps.uniqueIndex(valueList, e -> e + "key");
        System.out.println(map);
        //创建一个map，value的值依次为Set的元素,key为e+key,此map可变
        Map<String, String> map1 = Maps.asMap(Sets.newHashSet("1", "2", "3"), e -> e + "key");
        System.out.println(map1);
    }

    /**
     * 对map中的每一个value进行改变
     */
    @Test
    public void test1(){
        Map<String, String> map1 = Maps.asMap(Sets.newHashSet("1", "2", "3"), e -> e + "key");
        Map<String, String> map2 = Maps.transformValues(map1, v -> "new_add");
        System.out.println(map2);
    }
}
