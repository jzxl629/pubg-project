import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.control.*;

import java.lang.NumberFormatException;

public class GUI extends Application {
    private int w = 1000, h = 600;
    private int buttonStackOneCount = 10;
    private int buttonstackTwoCount = 10;
    private int btnHeightDiff = 35;
    private int bthHeight = 30;

    private int seconds = 0;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException {
        primaryStage.setTitle("PUBG Map");
        Group root = new Group();
        Model model = new Model();

        GridPane gridPane = new GridPane();

        //Loads the PUBG map
        Image map = new Image(new FileInputStream("C:\\Users\\jackl\\Desktop\\project\\WeChat Image_20181029004027.jpg"));
        ImageView view = new ImageView();
        view.setImage(map);
        final HBox pictureRegion = new HBox();
        pictureRegion.getChildren().add(view);
        gridPane.add(pictureRegion, 1, 1);


        //Creates an array for the buttons on top right
        ButtonBase[] btnStackOne = new ButtonBase[buttonStackOneCount];
        String[] btnStackOneTxt = new String[buttonStackOneCount];

        //Creates an array for second stack of buttons
        ButtonBase[] btnStackTwo = new ButtonBase[buttonStackOneCount];
        String[] btnStackTwoTxt = new String[buttonstackTwoCount];


        //initiation
        //whatever
        //put on to root


        //all bottons in arrays are initiated here
        for (int i = 0; i < btnStackOne.length; i++) {
            btnStackOne[i] = new Button();
            btnStackOneTxt[i] = new String("");
        }
        for (int i = 0; i < btnStackTwo.length; i++) {
            btnStackTwo[i] = new Button();
            btnStackTwoTxt[i] = new String("");
        }


        //naming
        //Button 0 coding TODO
        btnStackOneTxt[0] = "Flight Entry";
        //Button 1 coding TODO
        btnStackOne[1] = new ToggleButton();
        btnStackOneTxt[1] = "Distribution";
        //button 2 coding TODO
        btnStackOne[2] = new Button();
        btnStackOneTxt[2] = "Reset";
        //other button TODO


        //Timer button that will start the timer when it is pressed and start generating the priorities list
        btnStackTwoTxt[0] = "Start Timer";
        int secs = 0;
        Label timeLabel = new Label("Seconds from start: " + secs);
        timeLabel.setLayoutX(610);
        timeLabel.setLayoutY(10);
        root.getChildren().add(timeLabel);
        btnStackTwo[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Timer timer = new Timer();

                model.calculateRandomPriorities();
                model.sortPriorties();
                Label priorityLabel = new Label(model.toString());
                priorityLabel.setLayoutX(610);
                priorityLabel.setLayoutY(25);
                root.getChildren().add(priorityLabel);

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Timer ran " + ++seconds);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                timeLabel.setText("Seconds from start: " + seconds);
                                model.calculateRandomPriorities();
                                model.sortPriorties();
                                priorityLabel.setText(model.toString());
                            }
                        });
                    }
                }, 2000, 1000);
                btnStackTwo[0].setDisable(true);
            }
        });


        btnStackTwoTxt[1] = "Next Ring";
        btnStackTwo[1].setOnAction(new NextRingHandler());

        btnStackTwoTxt[2] = "Location";
        btnStackTwo[2].setOnAction(new LocationHandler());

        btnStackTwoTxt[3] = "Weapon1";
        btnStackTwo[3].setOnAction(new Weapon1Handler());

        btnStackTwoTxt[4] = "Weapon2";
        btnStackTwo[4].setOnAction(new Weapon2Handler());

        btnStackTwoTxt[4] = "Meds";
        btnStackTwo[4].setOnAction(new MedsHandler());

        //Creates stack one buttons in the interface
        for (int i = 0; i < btnStackOne.length; i++) {
            ButtonBase b = btnStackOne[i];
            b.setText(btnStackOneTxt[i]);
            b.setPrefHeight(bthHeight);
            b.setTranslateX(w - 400);
            b.setTranslateY(btnHeightDiff * i + 400);
        }

        //Creates stack 2 buttons in the interface
        for (int i = 0; i < btnStackTwo.length; i++) {
            ButtonBase b = btnStackTwo[i];
            b.setText(btnStackTwoTxt[i]);
            b.setTranslateX(w - 200);
            b.setTranslateY(btnHeightDiff * i);
        }


        //events go here


        //buttons are added to root here
        //Allows users to input the amount of ammo they own for weapon1 at a particular time in the game
        Label ammo1Count = new Label("Ammo1: ");
        TextField text1 = new TextField();
        text1.setPrefWidth(50);
        text1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        int ammo = Integer.parseInt(text1.getText());
                        model.getPlayer().setAmmo1(ammo);
                        System.out.println("Ammo1 Count: " + ammo);
                    } catch (NumberFormatException nf) {
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(ammo1Count, text1);
        hBox.setLayoutX(800);
        hBox.setLayoutY(500);
        root.getChildren().add(hBox);

        //Allows users to input the amount of ammo they own for weapon2 at a particular time in the game
        Label ammo2Count = new Label("Ammo2: ");
        TextField text2 = new TextField();
        text2.setPrefWidth(50);
        text2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        int ammo = Integer.parseInt(text2.getText());
                        model.getPlayer().setAmmo2(ammo);
                        System.out.println("Ammo2 Count: " + ammo);
                    } catch (NumberFormatException nf) {
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });
        HBox hbox = new HBox();
        hbox.getChildren().addAll(ammo2Count, text2);
        hbox.setLayoutX(800);
        hbox.setLayoutY(530);
        root.getChildren().add(hbox);


        //Checks if a user has vehicle at a particular time during the game
        CheckBox checkbox = new CheckBox("Vehicle");
        checkbox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkbox.isSelected()) {
                    model.getPlayer().setVehicle(true);
                } else {
                    model.getPlayer().setVehicle(false);
                }
            }
        });
        checkbox.setLayoutX(800);
        checkbox.setLayoutY(470);
        root.getChildren().add(checkbox);


        /***do not touch*/
        for (int i = 0; i < btnStackOne.length; i++) {
            ButtonBase b = btnStackOne[i];
            root.getChildren().add(b);
        }
        for (int i = 0; i < btnStackTwo.length; i++) {
            ButtonBase b = btnStackTwo[i];
            try {
                root.getChildren().add(b);
            } catch (Exception e) {
                System.out.println("Null at stack 2 i = " + i);
            }
        }


        root.getChildren().add(gridPane);
        Scene scene = new Scene(root, w, h, Color.WHITE);//h
        //how big is the window?


        primaryStage.setScene(scene);
        primaryStage.show();


    }


    //Nested class that handles the event when NextRing button is clicked
    private class NextRingHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Hello World");
        }
    }

    //Nested class that handles the event when Location button is clicked
    private class LocationHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }

    //Nested class that takes the input of user's weapon1
    private class Weapon1Handler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }

    //Nested class that takes the input of the user's weapon1
    private class Weapon2Handler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }

    //Nested class that takes input of users' meds
    private class MedsHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }


    public void run(String[] args) {
        launch(args);
    }
}

