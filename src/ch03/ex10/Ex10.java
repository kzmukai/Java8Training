package ch03.ex10;

/**
 * 。
 *
 * なぜ、次の呼び出しができないのでしょうか
 * UnaryOperator<T>のcompose メソッドの戻り値型を注意深く調べなさい。なぜ、 transform
 * メソッドに対しては、適切ではないのでしょうか。関数合成に関しては、ス トラクチャル型（structural type）とノミナル型（nominal
 * type）*4のユーティリティに関 して、何が言えますか。
 * 
 *
 */
public class Ex10 {
	
	// なぜ、次の呼び出しができないのでしょうか
	//Color::brighterの型はUnaryOperator<Color>、Color::grayscaleの型もUnaryOperator<Color>である
	//しかしUnaryOperator<T>のスーパーインターフェースのFunction<T,T>の default メソッドcomposeの戻り値の型はFunction<Color, Color>になる
	//ためビルドエラー
	
	
	//ransform メソッドに対しては、適切ではないのでしょうか。
	//?
	
	//関数合成に関しては、ス トラクチャル型（structural type）とノミナル型（nominaltype）*4のユーティリティに関 して、何が言えますか。
	//?
	
}
