package ch08.ex11;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * パスワード保護されたウェブページの内容を取得するプログラムを書きなさい。 URLConnection connection =
 * url.openConnection(); を呼び出しなさ い。文字列username:password を生成して、それをBase64 でエンコードしな
 * さい。それから、connection.setRequestProperty("Authorization", "Basic " + encoded
 * string) を呼び出し、次にconnection.connect() と connection.getInputStream() を呼び出しなさい。
 *
 */
public class BasicAuth {
	
	private InputStream basicAuthentication(URL url, String user, String password)
		    throws IOException {
		    URLConnection connection = url.openConnection();
		    // ユーザーコードとパスワードを Base64 でエンコード
		    Base64.Encoder encoder = Base64.getEncoder();
		    String auth = user + ":" + password;
		    auth = encoder.encodeToString(auth.getBytes(StandardCharsets.UTF_8));

		    connection.setRequestProperty("Authorization", "Basic " + auth);
		    connection.connect();
		    return connection.getInputStream();
		}
}
