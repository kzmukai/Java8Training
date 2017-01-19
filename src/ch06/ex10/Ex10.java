package ch06.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

/**
 * ユーザーにURLを問い合わせて、そのURLのウェブページを読み込み、全てのリンクを表示するプログラムを作成しなさい。
 * 各ステップに対して、CompletableFutureを使用しなさい。getを呼び出さないこと。
 * プログラムの処理が終わる前に終了しないようにするために、次の呼び出しを行いなさい。
 * ForkJoinPool.commonPool().awaitQuiescene(10, TimeUnit.SECONDS);
 */
public class Ex10 {

	private static Scanner stdin = new Scanner(System.in);

	// ユーザーにURLを問い合わせてコンソールから入力
	public static URL getURLInput(String prompt) {
		for (;;) {
			System.out.print(prompt + ": ");
			try {
				return new URL(stdin.nextLine());
			} catch (MalformedURLException ex) {
				// 間違った URL なら再入力
			}
		}
	}

	public static String blockingReadPage(URL url) {
		StringBuilder builder = new StringBuilder();
		// 文字コードは UTF-8 に固定する
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append('\n');
			}
		} catch (IOException ex) {
			// CompletableFuture を見越してチェック例外はスローしない
			throw new RuntimeException(ex);
		}
		return builder.toString();
	}

	public static class Paser extends HTMLEditorKit.ParserCallback {
		// リンク一覧
		private List<String> links = new ArrayList<String>();

		// anchor タグからリンク先を収集
		public void handleStartTag(HTML.Tag tag, MutableAttributeSet attrs, int pos) {
			if (tag.equals(HTML.Tag.A)) {
				links.add((String) attrs.getAttribute(HTML.Attribute.HREF));
			}
			super.handleStartTag(tag, attrs, pos);
		}

		// HTMLのリンク一覧の取得
		public static List<String> getLinks(String contents) {
			Paser callback = new Paser();
			ParserDelegator delegator = new ParserDelegator();
			try {
				delegator.parse(new StringReader(contents), callback, true);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			return callback.links;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CompletableFuture.supplyAsync(() -> getURLInput("URLを入力してください")).thenApplyAsync(Ex10::blockingReadPage)
				.thenApplyAsync(Paser::getLinks).thenAcceptAsync(System.out::println);
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}
}
