package test.io;

import com.google.common.base.*;
import com.google.common.collect.*;
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

    /**
     * 获取文件sha值
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        File file = new File(sources);
        //获取file的sha256值
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hash);
    }

    /**
     * 往文件里写入内容
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        String file = "C:\\课用软件\\workplace\\GuavaTest\\src\\test\\io\\resources\\write.txt";
        File file1 = new File(file);
        String content = "hello my baby";
        Files.asCharSink(file1,Charsets.UTF_8).write(content);
        file1.deleteOnExit();
    }

    /**
     * 往文件里追加内容
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        String file = "C:\\课用软件\\workplace\\GuavaTest\\src\\test\\io\\resources\\write.txt";
        File file1 = new File(file);
        String content = "thank you";
        CharSink charSink = Files.asCharSink(file1, Charsets.UTF_8, FileWriteMode.APPEND);
        charSink.write(content);
        //退出时删除文件
        file1.deleteOnExit();
    }

    /**
     * 创建一个文件
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        String file = "C:\\课用软件\\workplace\\GuavaTest\\src\\test\\io\\resources\\test.txt";
        File touchFile = new File(file);
        Files.touch(touchFile);
        //退出时删除文件
        touchFile.deleteOnExit();
    }

    /**
     * 获取根目录下的所有文件
     */
    @Test
    public void test6(){
        String path = "C:\\课用软件\\workplace\\GuavaTest\\src";
        File root = new File(path);
        //顺序获取根目录下的所有文件，包括目录
        FluentIterable<File> files = Files.fileTreeTraverser().preOrderTraversal(root);
         files.forEach(System.out :: println);
        //顺序获取根目录下的文件，不包括文件夹
        FluentIterable<File> files1 = Files.fileTreeTraverser().preOrderTraversal(root).filter(File::isFile);
        files1.forEach(System.out :: println);
        //逆序获取根目录下的所有文件，包括目录
        FluentIterable<File> files2 = Files.fileTreeTraverser().postOrderTraversal(root);
        files2.forEach(System.out :: println);
    }
}
