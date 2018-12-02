import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;
import java.awt.Graphics;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.HBox;

import javafx.scene.image.Image;
import java.io.FileNotFoundException;
import java.util.Timer;

public class pubg extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) throws FileNotFoundException{
        int h = 600;
        int w = 1000;

        primaryStage.setTitle("PUBG Map");
        Group root = new Group();


        GridPane gridPane = new GridPane();
        Image map = new Image(new FileInputStream("C:\\Users\\jackl\\Desktop\\project\\WeChat Image_20181029004027.jpg"));

        ImageView view = new ImageView();
        view.setImage(map);
        final HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(view);
        gridPane.add(pictureRegion,1,1);
        root.getChildren().add(gridPane);

        Button timer = new Button("Timer");
        timer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
                                       });
        timer.setLayoutX(800.0);
        timer.setLayoutY(0.0);
        root.getChildren().add(timer);

        Button nextRing = new Button("Next Ring");
        nextRing.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                long startTime = System.currentTimeMillis();
                long elpasedTime = System.currentTimeMillis() - startTime;
            }
        });
        timer.setLayoutX(800.0);
        timer.setLayoutY(0.0);
        root.getChildren().add(nextRing);


        Scene scene = new Scene(root, w, h, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
