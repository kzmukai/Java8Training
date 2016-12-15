package ch04.ex09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * 惑星を表す円をアニメーション化して、楕円軌道を回るようにしなさい。 PathTransition を使用します。
 */
public class Anime extends Application {
	public static void main(String[] args) {
		launch();
	}
	@Override
	public void start(Stage stage) throws Exception {
		 final double rX = 200;
		    final double rY = 160;
		    final double cX = rX + 24;
		    final double cY = rY + 24;
		    Ellipse orbit = new Ellipse(rX, rY);
		    orbit.setCenterX(cX);
		    orbit.setCenterY(cY);
		    orbit.setStroke(Color.LAVENDER);
		    orbit.setFill(null);
		    Circle earth = new Circle(16, Color.SLATEBLUE);
		    earth.setCenterX(cX + rX);
		    earth.setCenterY(cY);
		    Circle sun = new Circle(48, Color.CORAL);
		    sun.setCenterX(cX);
		    sun.setCenterY(cY);
		    PathTransition transition = new PathTransition();
		    transition.setNode(earth);
		    transition.setPath(orbit);
		    transition.setDuration(Duration.millis(4_000));
		    transition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		    transition.setInterpolator(Interpolator.LINEAR);
		    transition.setCycleCount(Animation.INDEFINITE);
		    transition.play();
		    Group group = new Group(orbit, earth, sun);
		    stage.setScene(new Scene(group, 2*cX, 2*cY));
		    stage.show();
		}}
