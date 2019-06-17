package test.collections;

import com.google.common.collect.*;
import org.junit.*;

import java.util.*;

/**
 * table
 */
public class TableTest {
    /**
     * table
     * 类似于一个表，有行名和列名。
     */
    @Test
    public void test(){
        HashBasedTable<String, String, String> table = HashBasedTable.create();
        table.put("Language","Java","1.8");
        table.put("Language","vue","1.2");
        table.put("database","mysql","4.1");
        System.out.println(table);
        //根据row获取值
        Map<String, String> language = table.row("Language");
        System.out.println(language);
        //根据colum获取值
        Map<String, String> column = table.column("vue");
        System.out.println(column);
        //获取整张表的数据
        Set<Table.Cell<String, String, String>> cells = table.cellSet();
        System.out.println(cells);

    }
}
