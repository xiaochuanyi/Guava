package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

public class BiMapTest {
    @Test
    public void test(){
        //创建一个bimap，此map 的value值不可重复.当出现重复的key时，会覆盖掉key的value
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1","2");
        biMap.put("1","3");
        System.out.println(biMap);
    }
    @Test
    public void test1(){
        //创建一个bimap，此map 的value值不可重复.当出现重复的key时，会覆盖掉key的value
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1","2");
        biMap.put("2","3");
        //反转map，即key和value互换
        BiMap<String, String> biMap1 = biMap.inverse();
    }


}
