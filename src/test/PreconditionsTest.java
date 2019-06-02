package test;

import com.google.common.base.*;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

public class PreconditionsTest {
    @Test
    public void test(){
        //检查传入的值是否为null，并给出提示信息
        String str = null;
        try {
            Preconditions.checkNotNull(str,"str should not be null");
        }catch (Exception e){
            e.printStackTrace();
        }
        //检查传入的值是否为想要的值，如果不是则抛出IllegalArgumentException异常
        String str1 = "A";
       try {
           Preconditions.checkArgument(str1.equals("B"));
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    @Test
    public void test1(){
        //确保访问索引指定有效元素
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        try{
            Preconditions.checkElementIndex(6,5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
