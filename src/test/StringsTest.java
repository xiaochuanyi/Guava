package test;

import com.google.common.base.*;
import org.junit.Test;

import java.nio.charset.*;

/**
 *Strings的一些方法
 */
public class StringsTest {
    @Test
    public void test(){
        //如果传入的是空字符串，则变为null值，否则不变
        System.out.println(Strings.emptyToNull("")+" "+Strings.emptyToNull("ss"));
        //如果传入的是null值，则变为空字符串，否则不变
        System.out.println(Strings.nullToEmpty(null)+" "+Strings.nullToEmpty("ss"));
        //如果传入的是null或者空字符串，则返回true，否则返回false
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));
    }
    @Test
    public void test0(){
        //获得公共前缀
        System.out.println(Strings.commonPrefix("helloworld","helloChina"));
        //获得公共后缀
        System.out.println(Strings.commonSuffix("helloworld","byeworld"));
        //获得翻倍的传入的字符串
        System.out.println(Strings.repeat("test",2));
    }
    @Test
    public void test1(){
        //如果字符串长度不够，则在字符串前填充值
        System.out.println(Strings.padStart("ello",6,'H'));
        //如果字符串长度不够，则在字符串填充值
        System.out.println(Strings.padEnd("hell",6,'0'));
    }
    @Test
    public void test2(){
        //获得字符串中包含的字符数量
        System.out.println(CharMatcher.is('A').countIn("A is my A"));
        //将空格替换为对应的字符
        System.out.println(CharMatcher.BREAKING_WHITESPACE.collapseFrom("   hello world",'A'));
        //移除字符串中的数字或者空格
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.BREAKING_WHITESPACE).removeFrom("hello  12 world"));
        //保留字符串中的空格或字符
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.BREAKING_WHITESPACE).retainFrom("hello  12 world"));
    }
}
