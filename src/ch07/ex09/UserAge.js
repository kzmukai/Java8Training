/**
 * 全ての環境変数を表示するスクリプトを書きなさい。
 */
for ( var v in $ENV) {
	print("${v}: ${$ENV[v]}")
}