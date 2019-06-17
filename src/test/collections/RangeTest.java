package test.collections;

import com.google.common.collect.*;
import org.junit.*;

/**
 * Range
 */
public class RangeTest {
    /**
     * 创建一个range
     */
    @Test
    public void test(){
        //创建一个o到9的range，包含0和9
        Range<Integer> closed = Range.closed(0, 9);
        System.out.println(closed);
        //创建一个0-9的range，不包含0和9
        Range<Integer> open = Range.open(0, 9);
        System.out.println(open);
        //创建一个0-9的range，不包含0包含9
        Range<Integer> openClosed = Range.openClosed(0, 9);
        System.out.println(openClosed);
        //创建一个0-9的range。包含0不包含9
        Range<Integer> closedOpen = Range.closedOpen(0, 9);
        System.out.println(closedOpen);
        //创建一个10到无穷大的range。不包含10
        Range<Integer> greaterThan = Range.greaterThan(10);
        System.out.println(greaterThan);
        //创建一个2到正无穷的range,包含2
        Range<Integer> atLeast = Range.atLeast(2);
        System.out.println(atLeast);
        //创建一个负无穷到2的range,不包含2
        Range<Integer> lessThan = Range.lessThan(2);
        System.out.println(lessThan);
    }
    @Test
    public void test1(){
        //创建一个RangeMap。key是一个范围值，为一个range，value为一个值。即一个范围对应一个值
        TreeRangeMap<Integer, String> treeRangeMap = TreeRangeMap.create();
        treeRangeMap.put(Range.closed(0,60),"F");
        treeRangeMap.put(Range.closed(61,70),"D");
        treeRangeMap.put(Range.closed(71,100),"A");
        System.out.println(treeRangeMap);

    }

}
