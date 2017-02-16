/**
 * 
 * ユーザの年齢を取得して, 年齢に1加えて, Next year, you will be ...と 表示するmextYear.jsスクリプトを書きなさい.
 * 年齢はコマンドラインで指定するか, 環境変数AGEで指定することができます. どちらも指定されていなければ, ユーザに問い合わせるようにしなさい
 */

var age = $ENV.AGE;
if ($ARG.length > 0) {
	age = $ARG[0];
}
if (!age || age != parseInt(age, 10)) {
	do {
		age = readLine('Your age: ');
	} while (age != parseInt(age, 10))
}
print("Next you will be ${++age}");
