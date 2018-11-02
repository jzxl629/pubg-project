import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GUI extends Application {
    int w = 1000,h=600;
    int buttonStackOneCount = 10;
    int buttonstackTwoCount = 10;
    int btnHeightDiff = 35;
    int bthHeight = 30;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("PUBG Map");
        Model model = new Model();
        Group root = new Group();

        GridPane gridPane = new GridPane();

        //Loads the PUBG map
        Image map = new Image(new FileInputStream("C:\\Users\\jackl\\Desktop\\project\\WeChat Image_20181029004027.jpg"));
        ImageView view = new ImageView();
        view.setImage(map);
        final HBox pictureRegion = new HBox();
        pictureRegion.getChildren().add(view);
        gridPane.add(pictureRegion,1,1);


        ButtonBase[] btnStackOne = new ButtonBase[buttonStackOneCount];
        String[] btnStackOneTxt = new String[buttonStackOneCount];

        ButtonBase[] btnStackTwo = new ButtonBase[buttonStackOneCount];
        String[] btnStackTwoTxt = new String[buttonstackTwoCount];

        //button initializations for stack one
        //Button 0 coding TODO
        btnStackOneTxt[0] = "Start Timer";
        //Button 1 coding TODO
        btnStackOne[1] = new ToggleButton();
        btnStackOneTxt[1] = "Flight Entry";
        //button 2 coding TODO
        btnStackOne[2] = new Button();
        btnStackOneTxt[2] = "";
        //other button TODO



        for(int i = 0; i< btnStackOne.length;i++){
            ButtonBase b = btnStackOne[i];
            b = new Button();
            b.setText(btnStackOneTxt[i]);
            b.setPrefHeight(bthHeight);
            b.setTranslateX(w - 400);
            b.setTranslateY(btnHeightDiff*i+400);

            root.getChildren().add(b);
        }

        //events go here


        //button initializations for stack two
        //button one coding
        btnStackTwo[0] = new Button();
        btnStackTwoTxt[0] = "Start Timer";
        btnStackTwo[0].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnStackTwo[1] = new Button();
        btnStackTwoTxt[1] = "Next Ring";
        btnStackTwo[1].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnStackTwo[2] = new Button();
        btnStackTwoTxt[2] = "Location";
        btnStackTwo[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnStackTwo[3] = new Button();
        btnStackTwoTxt[3] = "Primary Weapon";
        btnStackTwo[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnStackTwo[4] = new Button();
        btnStackTwoTxt[4] = "Ammo Count";
        btnStackTwo[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });



        for(int i = 0; i< btnStackTwo.length;i++){
            ButtonBase b = btnStackTwo[i];
            b = new Button();
            b.setText(btnStackTwoTxt[i]);
            b.setPrefHeight(bthHeight);
            b.setTranslateX(w - 200);
            b.setTranslateY(btnHeightDiff * i);

            root.getChildren().add(b);
        }

        JCheckBox checkbox = new JCheckBox("Vehicle");
        // check state
        if (checkbox.isSelected()) {
            System.out.println("Hello world!");

        } else {

        }

        //gridPane.add(checkbox, 900, 400);


        root.getChildren().add(gridPane);
        Scene scene = new Scene(root, w, h, Color.WHITE);//how big is the window?
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void run(String[] args) {
        launch(args);
    }
}
