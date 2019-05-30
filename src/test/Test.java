package test;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;

public class Test {
    public static Integer sum(Optional<Integer> a ,Optional<Integer> b){
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());
        Integer x = a.or(0);
        Integer y = b.or(0);
        return  x + y;
    }

    public static void main(String[] args) {
       Integer a = null;
       Integer b = new Integer(6);
       Optional<Integer> x = Optional.fromNullable(a);
       x.absent();
       Optional<Integer> y = Optional.fromNullable(b);
       System.out.println(sum(x,y));
    }
    }
