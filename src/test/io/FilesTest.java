package test.io;

import com.google.common.base.*;
import com.google.common.hash.*;
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
        //把文件的内容读取出来，读取的内容为一个list集合，一行为list集合中的一个对象
        List<String> strings = Files.readLines(new File(sources), Charsets.UTF_8);
        String result = Joiner.on("\n").join(strings);
        System.out.println(result);
        //读取文件,读取到的内容为一个字符串
        String read = Files.asCharSource(new File(sources),Charsets.UTF_8).read();
        System.out.println(read);
    }
    @Test
    public void test2() throws IOException {
        File file = new File(sources);
        //获取file的sha256值
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hash);
    }
    @Test
    public void test3() throws IOException {
        String file = "C:\\课用软件\\workplace\\GuavaTest\\src\\test\\io\\resources\\write.txt";
        File file1 = new File(file);
        String content = "hello my baby";
        Files.asCharSink(file1,Charsets.UTF_8).write(content);
    }
}
