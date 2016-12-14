package ch03.ex23;

import java.util.function.Function;

public class Pair<T> {
	  public final T first;
	    public final T second;

	    public Pair(T first, T second) {
	        this.first = first;
	        this.second = second;
	    }

	    // map 操作
	    public <U> Pair<U> map(Function<T, U> f) {
	        return new Pair<U>(f.apply(first), f.apply(second));
	    }
	}