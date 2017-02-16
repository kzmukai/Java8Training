package ch08.ex16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 市(city)、州(state)、郵便番号(zip code)を含む行を解析するために、名前付きキャプチャグループを用いた正規表現を使用せよ。
 * 郵便番号は、5桁と9桁（5桁ハイフン4桁）の両方を受け付けるようにせよ。
 *
 */
public class AdressAnalizer {

	public static void main(String[] args) { 
		
		Path path = Paths.get("C:CityData.txt");
		Pattern pattern = Pattern.compile(
		    "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2})\\s*,\\s*(?<zipCode>[0-9]{5}(-[0-9]{4})?)"
		);
		try {
		    for (String line : Files.readAllLines(path)) {
		        Matcher matcher = pattern.matcher(line);
		        if (matcher.matches())
		            continue;
		        System.out.print("City is "         + matcher.group("city"));
		        System.out.print(", State is "      + matcher.group("state"));
		        System.out.println(", Zip Code is " + matcher.group("zipCode"));
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
 	} 
	
}
