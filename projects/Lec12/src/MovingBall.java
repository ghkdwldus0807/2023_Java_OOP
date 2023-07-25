//21101989 황지연
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
public class MovingBall extends Application{
	

	@Override
	public void start(Stage primaryStage) {   
		

	    
	    Pane pane = new Pane();
	    
	    Polyline curve = new Polyline();
        for (int x = 50; x < 350; x++) {
            double t = (double) x / 100;
            double y = 200 / 2 - 60 * Math.cos(2 * Math.PI * t);
            curve.getPoints().addAll((double) x, y);
        }
        curve.setStroke(Color.RED);
        pane.getChildren().add(curve);
        
        Line xAxis = new Line(0, 200 / 2, 400, 200 / 2);
        pane.getChildren().add(xAxis);
        Line yAxis = new Line(400 / 2, 30, 400 / 2, 170);
        pane.getChildren().add(yAxis);
        
        Circle ball = new Circle(50,200 / 2 - 60 * Math.cos(2 * Math.PI * 0.5) , 10, Color.GREEN);
        pane.getChildren().add(ball);
 

        
        Text text1 = new Text(200, 20, "Y");
        pane.getChildren().add(text1);
        Text text2 = new Text(190, 115, "0");
        pane.getChildren().add(text2);
		Text text3 = new Text (140, 115, "-\u03c0");
		pane.getChildren().add(text3);
        Text text4 = new Text(250, 115, "\u03c0" );
        pane.getChildren().add(text4);
        Text text5 = new Text(90, 115, "-2\u03c0" );
        pane.getChildren().add(text5);
        Text text6 = new Text(290, 115, "2\u03c0" );
        pane.getChildren().add(text6);
        Text text7 = new Text(370, 90, "X" );
        pane.getChildren().add(text7);
        
        
        
	    Scene scene = new Scene(pane, 400, 200);
	    
	    
	    
	    
	    primaryStage.setTitle("CosineCurveBall"); 
	    primaryStage.setScene(scene); 
	    primaryStage.show(); 
	    
	    PathTransition pathTransition = new PathTransition();
	    pathTransition.setDuration(Duration.seconds(4)); 
	    pathTransition.setPath(curve);  
	    pathTransition.setNode(ball); 
	    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
	    pathTransition.setCycleCount(Timeline.INDEFINITE);  
	    pathTransition.setAutoReverse(true);  
	    
	    pane.setOnMousePressed(event -> {
	        if (event.getButton() == MouseButton.PRIMARY) {
	            pathTransition.pause();
	        } else if (event.getButton() == MouseButton.SECONDARY) {
	            pathTransition.play();
	        }
	    });

	    pathTransition.play(); 
   
    }
	

	public static void main(String[] args) {
		
		launch(args);
		
	}

}
