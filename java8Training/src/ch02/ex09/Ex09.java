package ch02.ex09;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;
/** 
  * Stream<ArrayList<T>>内のすべての要素を、1 つのArrayList<T>へまとめなさ い。具体的には、3 つの形式のreduce 
  * を用いる方法を示しなさい。 
  */ 

public class Ex09 {

    public static void main(final String... args) {
        final ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "a", "b", "c");
        final ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "d", "e", "f");
        final ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3, "g", "h", "i");

        reduce1(Stream.of(list1, list2, list3)).forEach(System.out::println);
        reduce2(Stream.of(list1, list2, list3)).forEach(System.out::println);
        reduce3(Stream.of(list1, list2, list3)).forEach(System.out::println);
    }

    public static <T> ArrayList<T> reduce1(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        });
    }

    public static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> stream) {
        return stream.reduce((ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        }).get();
    }

    public static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> stream) {
        final ArrayList<T> list = new ArrayList<>();
        return stream.reduce(list, (ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        }, (ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        });
    }
	
}
