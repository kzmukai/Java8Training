package ch08.ex07;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Queue;

/**
 * reversed を呼び出すことなく、nullsFirst(naturalOrder()).reversed() を表現しなさい。
 */

public class Ex07 {

	public static <T extends Comparable<? super T>> Comparator<T> reversedNullsLast() {
		return Comparator.nullsLast(Comparator.reverseOrder());
	}

}