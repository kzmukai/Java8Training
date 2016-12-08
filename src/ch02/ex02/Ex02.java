package ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 28 ページの2.1 節「イテレーションからストリーム操作へ」のfor ループの並列バー
 * ジョンを書きなさい。リストのセグメントごとに処理を行う別々のスレッドを多数生成
 * し、処理が終わるごとに結果を合計するようにしなさい（みなさんは、単一カウンターを 更新するためにスレッドを使用したくはないでしょう。なぜですか）。
 */

public class Ex02{

    /**
     * メイン関数.
     *
     * @param args 引数
     */
    public static void main(final String... args) {
        Stream.of("aaa", "bbbb", "ccccc", "dddddd", "eeeeeee", "ffffffff", "ggggggggg")
                .filter(s -> {
                    System.out.println(String.format("%s is filtered.", s));
                    return s.length() > 3;
                }).limit(5)
                .forEach(System.out::println);
    }
}
