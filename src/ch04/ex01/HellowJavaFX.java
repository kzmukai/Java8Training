package ch04.ex01;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * テキストフィールドとラベルを持つプログラムを作成しなさい。「Hello, JavaFX」プログ ラムと同じように、そのラベルは、文字列Hello, FX
 * を100 ポイントのフォントで表 示するようにしなさい。テキストフィールドを同じ文字列で初期化しなさい。ユーザーが
 * テキストフィールドを編集したらラベルも更新するようにしなさい。
 */
public class HellowJavaFX extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage stage) throws Exception {
		// ラベル
		Label message = new Label("Hello, JavaFX!");
		message.setFont(new Font(100.0));
		// スライダ
		Slider slider = new Slider();
		slider.setValue(100);
		slider.valueProperty().addListener(property -> message.setFont(new Font(slider.getValue())));
		// テキストフィールド
		TextField textField = new TextField(message.getText());
		textField.textProperty().addListener(property -> message.setText(textField.getText()));
		// 配置
		VBox root = new VBox();
		root.getChildren().addAll(textField, slider, message);
		stage.setScene(new Scene(root));
		stage.setTitle("Hello");
		stage.show();
	}
}