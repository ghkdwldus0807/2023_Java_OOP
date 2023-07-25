import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class practice13 extends Application {

    private ScrollBar redScrollBar;
    private ScrollBar greenScrollBar;
    private ScrollBar blueScrollBar;
    private ScrollBar opacityScrollBar;
    private Text text;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        redScrollBar = createScrollBar(0, 255, 0);
        greenScrollBar = createScrollBar(0, 255, 0);
        blueScrollBar = createScrollBar(0, 255, 0);
        opacityScrollBar = createScrollBar(0, 100, 100);

        text = new Text("Show Colors");

        redScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextFill());
        greenScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextFill());
        blueScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextFill());
        opacityScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextFill());

        updateTextFill();

        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 20px;");
        vbox.setAlignment(Pos.CENTER);

        HBox redBox = createLabeledScrollBarBox("Red", redScrollBar);
        HBox greenBox = createLabeledScrollBarBox("Green", greenScrollBar);
        HBox blueBox = createLabeledScrollBarBox("Blue", blueScrollBar);
        HBox opacityBox = createLabeledScrollBarBox("Opacity", opacityScrollBar);

        vbox.getChildren().addAll(text, redBox, greenBox, blueBox, opacityBox);

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setTitle("practice13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ScrollBar createScrollBar(double min, double max, double value) {
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(min);
        scrollBar.setMax(max);
        scrollBar.setValue(value);
        scrollBar.setUnitIncrement(1);
        scrollBar.setPrefWidth(200);
        return scrollBar;
    }

    private HBox createLabeledScrollBarBox(String labelName, ScrollBar scrollBar) {
        Label label = new Label(labelName);
        label.setPrefWidth(80);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getChildren().addAll(label, scrollBar);

        return hbox;
    }

    private void updateTextFill() {
        double red = redScrollBar.getValue();
        double green = greenScrollBar.getValue();
        double blue = blueScrollBar.getValue();
        double opacity = opacityScrollBar.getValue() / 100;

        text.setFill(Color.rgb((int) red, (int) green, (int) blue, opacity));
    }
}

