package test;

import com.google.common.base.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
/**
 *测试joiner
 */
public class JoinerTest {
    private List<String> list = Arrays.asList("xiao","li","liu","deng");
    private List<String> list1 = Arrays.asList("xiao","li","liu","deng",null);
    @Test
    public void test(){
        //获得List集合所有对象的字符串，并且可以在对象之间添加字符串，但是集合中有null会报异常
        String result = Joiner.on("##").join(list);
        System.out.println(result);
        //去除掉所有空值
        String result1 = Joiner.on("##").skipNulls().join(list1);
        System.out.println(result1);
        //把空值替换为默认值
        String result3 = Joiner.on("##").useForNull("空值替换").join(list1);
        System.out.println(result3);
    }
    @Test
    public void test1(){

    }

}
