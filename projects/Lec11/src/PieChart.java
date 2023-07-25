//21101989 황지연

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
public class PieChart extends Application{
	@Override
	public void start(Stage primaryStage) {   
	    Arc arc1 = new Arc(150, 100, 80, 80, 0, 72); 
	    arc1.setFill(Color.RED); 
	    arc1.setType(ArcType.ROUND); 
	    
	    Arc arc2 = new Arc(150, 100, 80, 80, 72, 93.6); 
	    arc2.setFill(Color.BLUE);
	    arc2.setType(ArcType.ROUND);
	    
	    Arc arc3 = new Arc(150, 100, 80, 80, 165.6, 100.8); 
	    arc3.setFill(Color.GREEN);
	    arc3.setType(ArcType.ROUND);
	    
	    Arc arc4 = new Arc(150, 100, 80, 80, 266.4, 93.6); 
	    arc4.setFill(Color.ORANGE);
	    arc4.setType(ArcType.ROUND);
	    
	    BorderPane pane = new BorderPane();
        pane.setCenter(new javafx.scene.Group(arc1,arc2,arc3,arc4));
        
        Text text1 = new Text(30, 30, "HTC -- 26%");
        pane.getChildren().add(text1);
        Text text2 = new Text(200, 30, "Apple -- 20%");
        pane.getChildren().add(text2);
        Text text3 = new Text(30, 150, "Samsung -- 28%");
        pane.getChildren().add(text3);
        Text text4 = new Text(200, 150, "Others -- 26%");
        pane.getChildren().add(text4);
	    
	    Scene scene = new Scene(pane, 300, 200);
	    primaryStage.setTitle("PieChart"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	}
	

	public static void main(String[] args) {
		
		launch(args);
		
	}

}
