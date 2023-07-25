import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;

public class MyJavaFX extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		Button btOK = new Button("OK");
		Scene scene = new Scene(btOK, 200, 250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
		

	}

}
