package ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import ch03.ex11.ColorTransfomer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 69 ページの3.6 節「遅延」のLatentImage を機能拡張して、UnaryOperator<Color>と ColorTransformer
 * の両方をサポートするようにしなさい。 ヒント：UnaryOperator<Color>をColorTransformer へ適応させなさい。
 *目視で確認
 */
public class LatentImage extends Application {
	
	public static void main(String[] args) {
		launch();
	}


    private Image in;
    private List<UnaryOperator<Color>> pendingOperations;

    public static LatentImage from(Image in) {
        LatentImage result = new LatentImage();
        result.in = in;
        result.pendingOperations = new ArrayList<>();
        return result;
    }

    LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(f);
        return this;
    }
    
    LatentImage transform(ColorTransfomer ct) {
        pendingOperations.add(c -> ct.apply(0, 0, c));
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations) {
                    c = f.apply(c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }


	public void start(Stage stage) throws Exception {
		 Image image = new Image("lena.jpg");
		 ColorTransfomer ct = (x, y, c) -> c.grayscale();
	        Image finalImage1 = LatentImage.from(image)
	                .transform(Color::brighter).transform(ct)
	                .toImage();
	        stage.setScene(new Scene(new HBox(
	                new ImageView(image),
	                new ImageView(finalImage1))));
	        stage.show();
		
	}
	
}