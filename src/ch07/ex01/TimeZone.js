/** 
*例えば, ZonedDateTimeクラスなど, 試してみたいJava APIを選びなさい. 
*その上で, オブジェクトの生成, メソッドの呼び出し, 戻り値の表示など, jssを使った実験を行いなさい. 
*また, Javaでプログラムを書くよりは簡単かどうかを検証しなさい. 
*
*簡単、mainを書くことなく結果が確認できるため。
*
*/

var LocalDate= java.time.LocalDate; 
var date = LocalDate.of(2017, 2, 14); 
print(date); 
print(date.plusYears(1)); 
