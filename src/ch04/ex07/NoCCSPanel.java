package ch04.ex07;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * CSS を使用しないで、コントロールの境界を設定する方法を調べなさい。
 */
public class NoCCSPanel extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		TextField defaultField = new TextField("sample");
		TextField strokeField = new TextField("Stroke Border");

		final double em = new Text("").getLayoutBounds().getHeight();
		strokeField.setPrefHeight(4.0 * em);
		strokeField.setBorder(new Border(new BorderStroke(Color.BLUE, Color.GREEN, Color.RED, Color.DARKOLIVEGREEN,
				BorderStrokeStyle.SOLID, BorderStrokeStyle.DOTTED, BorderStrokeStyle.DASHED, BorderStrokeStyle.SOLID,
				new CornerRadii(0.2 * em, 1.0 * em, 0.2 * em, 2.5 * em, false), new BorderWidths(1.0, 2.0, 3.0, 4.0),
				new Insets(0.5 * em))));
		VBox root = new VBox();
		root.getChildren().addAll(defaultField, strokeField);
		stage.setScene(new Scene(root));
		stage.show();
	}

}
