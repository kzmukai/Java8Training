package ch04.ex10;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class URL extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
	    Button backButton = new Button("戻る");
	    TextField urlField = new TextField();
	    WebView browser = new WebView();
	    WebEngine engine = browser.getEngine();
	    backButton.setOnAction(
	        event -> { engine.getHistory().go(-1); }
	    );
	    backButton.disableProperty().bind(     
	    		Bindings.equal(0, engine.getHistory().currentIndexProperty())
	    );
	    urlField.setOnAction(                  
	        event -> { engine.load(urlField.getText()); }
	    );
	    engine.locationProperty().addListener( 
	        (location, oldLocation, newLocation) -> { urlField.setText(newLocation); }
	    );
	    engine.load("https://www.google.co.jp/");
	    HBox box = new HBox(backButton, urlField);
	    HBox.setHgrow(urlField, Priority.ALWAYS);
	    BorderPane pane = new BorderPane();
	    pane.setTop(box);
	    pane.setCenter(browser);

	    stage.setScene(new Scene(pane, 600, 400));
	    stage.setTitle("Browser");
	    stage.show();
	}

}
