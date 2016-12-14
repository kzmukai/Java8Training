package ch03.ex11;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
* 2 つのColorTransformer オブジェクトを合成できるstatic メソッドを実装しなさい。そして、x 座標とy
* 座標を無視するColorTransformerへUnaryOperator<Color>を変えるstaticメソッドを実装しなさい。それから、
* 変換によって明るくなった画像に灰色の枠を追加するために、実装したメソッドを使用しなさい（灰色の枠に関しては練習問題5 を参照しなさい）。
*/
public class ColorTransform extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	public static Image transform(Image in, ColorTransfomer f) {
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
	    int width = (int)image.getWidth();
	    int height = (int)image.getHeight();
	    Image image2;
	    ColorTransfomer grayFrame =
	        (x, y, c) ->
	        x < 10 || y < 10 || x >= width - 10 || y >= height - 10 ? Color.GRAY : c;
	    image2 = transform(image, grayFrame.compose(ColorTransfomer.onlyColor(Color::brighter)));
	    stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
	    stage.show();
	}

}
