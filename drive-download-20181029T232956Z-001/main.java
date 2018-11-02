


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class main extends Application {
    int w = 1000,h=600;
    int buttonCount = 3;
    int btnHeightDiff = 35;
    int bthHeight = 30;
    @Override
    public void start(Stage primaryStage) {
        Model.
        GridPane root = new GridPane();
        ButtonBase[] btns = new ButtonBase[buttonCount];
        String[] btnTxt = new String[buttonCount];

        //button initialiations
        //Button 0 coding TODO
        btnTxt[0] = "Start Timer";
        //Button 1 coding TODO
        btns[1] = new ToggleButton();
        btnTxt[1] = "Flight Entry";
        //button 2 coding TODO
        btns[2] = new Button();
        btnTxt[2] = "";
        //other button TODO


        for(int i = 0; i< btns.length;i++){
            ButtonBase b = btns[i];
            b = new Button();
            b.setText(btnTxt[i]);
            b.setPrefHeight(bthHeight);
            b.setTranslateX(w - 400);
            b.setTranslateY(btnHeightDiff*i+400);

            root.getChildren().add(b);
        }

        //events go here
        btns[0].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });




        Scene scene = new Scene(root, w, h);//how big is the window?

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}