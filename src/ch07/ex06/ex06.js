/**
 * 一連のシェルコマンドを受け取り、1つのコマンドの出力を次のコマンドの入力として接続し、 最後の出力を返すJavaScriptのPipe関数を書きなさい。
 * 
 */

function pipe() {
	var result;
	for (var i = 0; i < arguments.length; i++) {
		result = $EXEC(arguments[i], result);
	}
	return result;
}

pipe('find .', 'grep src.zip', 'sort')
print($OUT)
