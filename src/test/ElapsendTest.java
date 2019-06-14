package test;

import java.util.concurrent.*;

/**
 * 日志测试
 */
public class ElapsendTest {
    public static void main(String[] args) throws InterruptedException {
        process("1000");
    }
    private static void process(String order) throws InterruptedException {
        long startTime = System.nanoTime();
        System.out.printf("start process the order %s\n",order);
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("end process the order %d\n",(System.nanoTime() - startTime));
    }
}
