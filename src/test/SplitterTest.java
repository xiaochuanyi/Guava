package test;

import com.google.common.base.*;
import org.junit.Test;

import java.util.*;

/**
 * 测试Splitter类的方法，作用是分割字符串
 * {@link Splitter}
 */
public class SplitterTest {
    @Test
    public void test(){
        String str = "xcy|liu|hello|||";
        //根据|分割字符串,但是它不会忽略null值，即有两个||在一起，它也会分割开来
        List<String> result = Splitter.on("|").splitToList(str);
        Iterator i = result.iterator();
        System.out.println(result.size());
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        //忽略两个连在一起的分隔符导致的null值
        List<String> result1 = Splitter.on("|").omitEmptyStrings().splitToList(str);
        Iterator i1 = result1.iterator();
        System.out.println(result1.size());
        while (i1.hasNext()){
            System.out.println(i1.next());
        }
        //去除掉分割字符前后的空格
        String str1 = "xcy  ||  liu |   deng  |||";
        List<String> result2 = Splitter.on("|").trimResults().omitEmptyStrings().splitToList(str1);
        Iterator i2 = result2.iterator();
        System.out.println(result2.size());
        while (i2.hasNext()){
            System.out.println(i2.next());
        }
    }
    @Test
    public void test1(){
        //根据长度分割字符串
        String str = "aabbccdd";
        List<String> result = Splitter.fixedLength(2).splitToList(str);
        System.out.println(result.size());
        Iterator i = result.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        //limit的作用，根据limit的数字，会获得对应数字的list集合。
        String str1 = "aaa#bbb#ccc#ddd";
        List<String> result1 = Splitter.on("#").limit(3).splitToList(str1);
        System.out.println(result1.size());
        Iterator i1 = result1.iterator();
        while (i1.hasNext()){
            System.out.println(i1.next());
        }
    }
    @Test
    public void test2(){
        //根据=获得map集合，=号前为key,后为value
        String str = "key=world || key1=world1";
        Map<String, String> result = Splitter.on("|").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(str);
        System.out.println(result.get("key"));
        System.out.println(result.get("key1"));
    }
}
