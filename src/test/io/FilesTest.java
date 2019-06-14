package test.io;

import com.google.common.base.*;
import com.google.common.io.*;
import org.junit.*;

import java.io.*;
import java.util.*;


/**
 * 关于IO的测试
 */
public class FilesTest {
    private final String sources = "C:\\课用软件\\workplace\\GuavaTest\\src\\test\\io\\resources\\sources.txt";
    private final String target = "C:\\课用软件\\workplace\\GuavaTest\\src\\test\\io\\resources\\target.txt";

    /**
     * TODO XCY will finish it in the future.
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        File sourcesFile = new File(sources);
        File targetFiles = new File(target);
        //复制sourcesFiles文件到目标文件targetFiles去
        Files.copy(sourcesFile, targetFiles);
        //移动sourcesFiles文件到targetFiles文件去
        Files.move(sourcesFile,targetFiles);
    }
    @Test
    public void test1() throws IOException {
        //把文件的内容读取出来
        List<String> strings = Files.readLines(new File(sources), Charsets.UTF_8);
        String result = Joiner.on("\n").join(strings);
        System.out.println(result);
    }
}
