package ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 91 ページの4.5 節「バインディング」のプログラムについて、円が真ん中に配置され、 シーンの4 つの辺の少なくとも2
 * つの辺に常に接するように機能拡張しなさい。
 */
public class Binding extends Application {

	 public static void main(String[] args) {
	        launch();
	    }
	
	public void start(Stage stage) throws Exception {
	    Circle circle = new Circle(50, 100, 100);
	    circle.setFill(Color.BROWN);
	    Pane pane = new Pane();
	    pane.getChildren().add(circle);
	    Scene scene = new Scene(pane);
	    // 円と Scene のバインディング
	    circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(),  2.0));
	    circle.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2.0));
	    circle.radiusProperty().bind(
	    		Bindings.divide( Bindings.min(scene.widthProperty(), scene.heightProperty()), 2.0));
	    stage.setScene(scene);
	    stage.show();
	}
}
