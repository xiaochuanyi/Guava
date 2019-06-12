package test;

import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.collect.*;

import java.util.*;

/**
 * MoreObnject的一些方法
 * 用于重写toString、equals、hashcode等
 */
public class ObjectTest{
    static class Guava implements Comparable<Guava>{
        private final String manufacturer;//生产厂家
        private final String version;//版本号
        private final Calendar releaseDate;//生产日期
        public Guava(String manufacturer, String version, Calendar releaseDate) {
            this.manufacturer = manufacturer;
            this.version = version;
            this.releaseDate = releaseDate;
        }

        /**
         * 比较器,
         * @param o
         * @return
         */
        @Override
        public int compareTo(Guava o) {
            return ComparisonChain.start().compare(this.manufacturer,o.manufacturer)
                    .compare(this.version,o.version).compare(this.releaseDate,o.releaseDate).result();
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("manufacturer",this.manufacturer)
                    .add("version",this.manufacturer)
                    .add("releaseDate",this.releaseDate).toString();
        }
        @Override
        public int hashCode() {
            return Objects.hashCode(manufacturer,manufacturer,releaseDate);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Guava guava = (Guava) o;
          return Objects.equal(this.manufacturer,guava.manufacturer)
                  &&Objects.equal(this.version,guava.version)
                  &&Objects.equal(this.manufacturer,guava.manufacturer);
        }
    }
    public static void main(String[] args) {
        final Guava guava = new Guava("Google","23.0",Calendar.getInstance());
        System.out.println(guava.toString());
        System.out.println(guava.hashCode());
    }
}
