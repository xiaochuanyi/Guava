package test;

import com.google.common.base.*;

/**
 * 函数式接口
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> function = new Function<String, Integer>() {

            @Override
            public Integer apply(String input) {
                Preconditions.checkNotNull(input, "The input String not be null");
                return input.length();
            }
        };
        System.out.println(function.apply("hello"));
        process("hello",new LengthToDouble());
    }
    interface Handler<IN,OUT>{
        OUT handle(IN input);
    }
    static class LengthToDouble implements Handler<String,Integer>{
        @Override
        public Integer handle(String input) {
            return input.length() * 2;
        }
    }
    private static void process(String text,Handler<String,Integer> handler){
        System.out.println(handler.handle(text));
    }

}
