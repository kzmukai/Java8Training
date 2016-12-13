package ch03.ex19;

/**
 ** Stream<T>のメソッドである<U> U reduce(U identity, BiFunction<U, ? super T, U>
 * accumulator, BinaryOperator<U> combiner) を見てみなさ い。BiFunction への最初の型引数でU を?
 * super U と宣言すべきですか。その理由 は、何ですか。
 *
 */
public class Ex19 {

	//すべきでない
	
//	U result = identify;
//	for (T element : stream) {
//	    result = accumulator.apply(result, element);
//	}
//	return result;


	//これを見るとaccumulatorのapplyメソッドの第一引数の型は常に U で、U の親クラスになることはない

}

