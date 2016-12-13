package ch03.ex05;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
/**
 * 次は、ColorTransformer の具体例です。次のように、画像の周りに枠を付加します。
 * 
 * 最初に、62 ページの3.3 節「関数型インタフェースの選択」のtransform メソッドを、 UnaryOperator
 * <Color>の代わりにColorTransformer で実装しなさい。それか ら、画像の周りの10
 * ピクセルを灰色の枠で置き換えるために、そのtransform メソッ ドを適切なラムダ式で呼び出しなさい。
 * 
 * テストは目視で確認
 */


public class ImageTransform  extends Application{
	public static void main(String[] args) { 
 		launch(); 
 		} 
	
	@FunctionalInterface
	interface ColorTransformern{
		Color apply(int x, int y, Color colorAtXY);
	}

	public static Image transform(Image in, ColorTransformern f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	public void start(Stage stage) throws Exception {
		Image image = new Image("lena.jpg");
		int width = (int) image.getWidth();
		int height = (int) image.getHeight();
		Image image2 = transform(image,
				(x, y, c) -> x < 10 || y < 10 || x >= width - 10 || y >= height - 10 ? Color.GRAY : c);
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		stage.show();
	}
}