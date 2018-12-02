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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
import javafx.util.StringConverter;

import java.util.Timer;
import java.util.TimerTask;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.lang.NumberFormatException;

//This class contains the graphical user interface
public class GUI extends Application {

    //Stores the width and height of the interface
    private int w = 1000, h = 600;

    //Stores stack one buttons
    private int buttonStackOneCount = 5;

    //Stores stack two buttons
    private int buttonstackTwoCount = 10;

    //Stores the distance between two buttons
    private int btnHeightDiff = 35;

    //Stores the height of the button
    private int bthHeight = 30;

    //Stores the time
    private int seconds = 0;




    //Creates an array for the buttons on top right
    ButtonBase[] btnStackOne = new ButtonBase[buttonStackOneCount];
    //Creats an array for the names of the buttons
    String[] btnStackOneTxt = new String[buttonStackOneCount];

    //Creates an array for second stack of buttons
    ButtonBase[] btnStackTwo = new ButtonBase[buttonStackOneCount];
    //Creates an array for the names of the second stack of buttons
    String[] btnStackTwoTxt = new String[buttonstackTwoCount];
    //Override the starter method to set up the user interface
    private Coordinate lastEntry;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException {

        //Names the interface
        primaryStage.setTitle("PUBG Map");

        //Creates a new root
        Group root = new Group();

        //Creates a model of the support system
        Model model = new Model();
        model.gui = this;
        //Creates a new grid pane
        GridPane gridPane = new GridPane();

        //Loads the PUBG map from the directory
        Image map = new Image(new FileInputStream("C:\\Users\\jackl\\Desktop\\393 project\\WeChat Image_20181029004027.jpg"));

        //Creates a new image view
        ImageView view = new ImageView();
        //Sets the image
        view.setImage(map);

        Line flightline = new Line();
        Circle circle = new Circle(135,206,235);
        Circle myLocation = new Circle();
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();
                System.out.println("X" + x);
                System.out.println("Y" + y);
                lastEntry = new Coordinate((int)x,(int)y);
                if(((ToggleButton)btnStackOne[0]).isSelected()){
                    model.game.addToFlightPath(lastEntry);
                    if(model.game.getFlightPath().getState()==2){
                        //todo fix exception
                        int x1 = model.game.getFlightPath().getC1().getX();
                        int y1 = model.game.getFlightPath().getC1().getY();
                        int x2 = model.game.getFlightPath().getC2().getX();
                        int y2 = model.game.getFlightPath().getC2().getY();
                        int x3 = 0;
                        int y3 = (-1)*x1 *(y1-y2)/(x1-x2) + y1;
                        int x4 = 600;
                        int y4 = (600-x1) *(y1-y2)/(x1-x2) + y1;
                        flightline.setStartX(x3);
                        flightline.setStartY(y3);
                        flightline.setEndX(x4);
                        flightline.setEndY(y4);
                        flightline.setStrokeWidth(3.0);
                        flightline.setMouseTransparent(true);
                        root.getChildren().add(flightline);
                    }else{
                        flightline.setManaged(false);
                    }
                }else if(((ToggleButton)btnStackOne[1]).isSelected()){
                    SafeZone sz = model.game.getSafeZone();
                    sz.input(lastEntry);
                    if(sz.getState()==2){
                        circle.setCenterX(sz.getCenter().getX());
                        circle.setCenterY(sz.getCenter().getY());
                        circle.setRadius(sz.getRadius());
                        circle.setOpacity(.5);
                        circle.setFill(Color.BLUE);
                        circle.setMouseTransparent(true);
                        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                double x = mouseEvent.getX();
                                double y = mouseEvent.getY();
                                System.out.println("X" + x);
                                System.out.println("Y" + y);
                                lastEntry = new Coordinate((int)x,(int)y);
                            }});

                        root.getChildren().add(circle);
                    }else{
                        circle.setManaged(false);
                    }
                }else if(((ToggleButton)btnStackOne[2]).isSelected()){
                    myLocation.setFill(Color.YELLOW);
                    myLocation.setCenterY(lastEntry.getY());
                    myLocation.setCenterX(lastEntry.getX());
                    myLocation.setRadius(3.0);
                    root.getChildren().add(myLocation);
                    myLocation.setMouseTransparent(true);
                    model.player.setLocation(new Coordinate(lastEntry.getX(),lastEntry.getY()));
                }
            }
        });

        //Creates a pictureRegion
        final HBox pictureRegion = new HBox();

        //Adds the image to the region
        pictureRegion.getChildren().add(view);

        //Adds the image to the grid pane and sets the indices
        gridPane.add(pictureRegion, 1, 1);




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

        btnStackOne[0] = new ToggleButton();
        btnStackOne[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                boolean selected = ((ToggleButton)btnStackOne[0]).isSelected();
                if(selected) {
                    unToggle();
                    ((ToggleButton)btnStackOne[0]).setSelected(true);
                }

                System.out.println("Flight button toggled to" + ((ToggleButton)btnStackOne[0]).isSelected());
            }
        });
        btnStackOneTxt[0] = "Flight Entry";
        //Button 1 coding TODO
        btnStackOne[1] = new ToggleButton();
        btnStackOne[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                boolean selected = ((ToggleButton)btnStackOne[1]).isSelected();
                if(selected) {
                    unToggle();
                    ((ToggleButton)btnStackOne[1]).setSelected(true);
                }

                System.out.println("safe zone toggled to" + ((ToggleButton)btnStackOne[1]).isSelected());
            }});

        btnStackOneTxt[1] = "Safe Zone";

        btnStackOne[2] = new ToggleButton();
        btnStackOneTxt[2] = "Player location";
        btnStackOne[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean selected = ((ToggleButton)btnStackOne[2]).isSelected();
                if(selected) {
                    unToggle();
                    ((ToggleButton)btnStackOne[2]).setSelected(true);
                }
            }
        });


        btnStackOne[3] = new Button();
        btnStackOneTxt[3] = "Reset";
        btnStackOne[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circle.setFill(Color.TRANSPARENT);
                flightline.setStrokeWidth(0.0);
                myLocation.setFill(Color.TRANSPARENT);
                root.getChildren().remove(myLocation);
                root.getChildren().remove(circle);
                root.getChildren().remove(flightline);
                model.game.getFlightPath().setState(0);
                model.game.getSafeZone().setState(0);

            }
        });
        //other button TODO



        //Timer button that will start the timer when it is pressed and start generating the priorities list
        btnStackTwoTxt[0] = "Start Timer";
        int secs = 0;
        //Creates a time label that count the game time
        Label timeLabel = new Label("Seconds from start: " + secs);
        //Sets the indices of the time label
        timeLabel.setLayoutX(610);
        timeLabel.setLayoutY(10);
        root.getChildren().add(timeLabel);
        //Creates an event handler that starts the timer when the timer button is clicked
        btnStackTwo[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Timer timer = new Timer();

                model.calculateRandomPriorities();
                model.sortPriorties();
                Label priorityLabel = new Label(model.objToString()+model.toString());
                priorityLabel.setLayoutX(610);
                priorityLabel.setLayoutY(25);
                root.getChildren().add(priorityLabel);

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Timer ran " + ++seconds);
                        model.game.scs = seconds;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                timeLabel.setText("Seconds from start: " + seconds);
                                model.calculateRandomPriorities();
                                model.sortPriorties();
                                priorityLabel.setText(model.objToString()+model.toString());
                            }
                        });
                    }
                }, 2000, 1000);
                btnStackTwo[0].setDisable(true);
            }
        });

        /*
        //Names stack two buttons and creates event handlers
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
        */

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


        //Allows users to choose for weapon1: no weapon, pistol, smg, shotgun, rifle, sniper
        Label weapon1 = new Label("Weapon 1");
        Slider slider = new Slider( 0, 5, 0);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit(1);

        slider.valueProperty().addListener((obs, oldval, newVal) -> {
                    slider.setValue(newVal.intValue());
                    model.getPlayer().setWeapon1(newVal.intValue());
                    //System.out.println("Weapon status: " + model.getPlayer().getWeapon1());
                }
        );

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object < 0.5) {
                    return "no weapon";
                    //GUI.this.model.getPlayer().setWeapon1(1);
                }
                if(object < 1.5)
                    return "pistol";
                if(object < 2.5)
                    return "smg";
                if(object < 3.5)
                    return "shotgun";
                if(object < 4.5)
                    return "rifle";
                if(object < 5.5)
                    return "sniper";

                return "no weapon";
            }
            //Labels the slider with six different strings each represents a weapon status
            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "no weapon":
                        return 0d;
                    case "pistol":
                        return 1d;
                    case "smg":
                        //model.getPlayer().setWeapon1(2);
                        return 2d;
                    case "shotgun":
                        // model.getPlayer().setWeapon1(3);
                        return 3d;
                    case "rifle":
                        //model.getPlayer().setWeapon1(4);
                        return 4d;
                    case "sniper":
                        //model.getPlayer().setWeapon1(5);
                        return 5d;

                    default:
                        //model.getPlayer().setWeapon1(0);
                        return 0d;
                }
            }
        });

        //Sets the minimum height of the slider
        slider.setMinHeight(60);

        //set the position of the slider to be drawn
        slider.setLayoutX(800);
        slider.setLayoutY(210);
        root.getChildren().add(slider);

        //set the position of the label
        weapon1.setLayoutX(800);
        weapon1.setLayoutY(185);
        root.getChildren().add(weapon1);


        //Allows users to choose for weapon2: no weapon, pistol, smg, shotgun, rifle, sniper
        Label weapon2 = new Label("Weapon 2");
        Slider slider2 = new Slider( 0, 5, 0);
        //Creates a vertical slider
        slider2.setOrientation(Orientation.VERTICAL);
        slider2.setShowTickLabels(true);
        slider2.setShowTickMarks(true);
        slider2.setMinorTickCount(0);
        slider2.setMajorTickUnit(1);

        slider2.valueProperty().addListener((obs, oldval, newVal) -> {
                    slider2.setValue(newVal.intValue());
                    model.getPlayer().setWeapon2(newVal.intValue());
                    //System.out.println("Weapon2 status: " + model.getPlayer().getWeapon2());
                }
        );

        //Labels the slider with six different strings each represents a weapon status
        slider2.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object < 0.5) {
                    return "no weapon";
                }
                if(object < 1.5)
                    return "pistol";
                if(object < 2.5)
                    return "smg";
                if(object < 3.5)
                    return "shotgun";
                if(object < 4.5)
                    return "rifle";
                if(object < 5.5)
                    return "sniper";

                return "no weapon";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "no weapon":
                        return 0d;
                    case "pistol":
                        return 1d;
                    case "smg":
                        return 2d;
                    case "shotgun":
                        return 3d;
                    case "rifle":
                        return 4d;
                    case "sniper":
                        return 5d;

                    default:
                        return 0d;
                }
            }
        });

        //Sets the minimum height of the slider
        slider2.setMinHeight(60);

        //set the position of the slider to be drawn
        slider2.setLayoutX(900);
        slider2.setLayoutY(210);
        root.getChildren().add(slider2);

        //set the position of the label
        weapon2.setLayoutX(900);
        weapon2.setLayoutY(185);
        root.getChildren().add(weapon2);


        //Allows users to input the amount of bandage they own
        //buttons are added to root here
        //Allows users to input the amount of bandage they own
        Label bandageCount = new Label("Bandage: ");
        TextField textBandage = new TextField();
        textBandage.setPrefWidth(50);
//Creates an event handler that stores the amount of bandage input by users
        textBandage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //Users can press enter to input the bandage
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        //Stores the amount of bandage
                        int bandage = Integer.parseInt(textBandage.getText());
                        //Sets the amount of bandage owned by the player
                        model.getPlayer().setBanddage(bandage);
                        System.out.println("Bandage Count: " + bandage);
                    } catch (NumberFormatException nf) {
                        //Warns users if their input is not an integer
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });

        //Adds the textfield to the interface
        HBox bandageBox = new HBox();
        bandageBox.getChildren().addAll(bandageCount, textBandage);
        bandageBox.setLayoutX(800);
        bandageBox.setLayoutY(470);
        root.getChildren().add(bandageBox);


        //Allows users to input the amount of medkit they own
        //buttons are added to root here
        //Allows users to input the amount of medkit they own
        Label medkitCount = new Label("Medkit: ");
        TextField textMedkit = new TextField();
        textMedkit.setPrefWidth(50);
        //Creates an event handler that stores the amount of medkit input by users
        textMedkit.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //Users can press enter to input the medkit
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        //Stores the amount of medkit
                        int medkit = Integer.parseInt(textMedkit.getText());
                        //Sets the amount of medkit owned by the player
                        model.getPlayer().setMedkit(medkit);
                        System.out.println("Medkit Count: " + medkit);
                    } catch (NumberFormatException nf) {
                        //Warns users if their input is not an integer
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });

        //Adds the textfield to the interface
        HBox medkitBox = new HBox();
        medkitBox.getChildren().addAll(medkitCount, textMedkit);
        medkitBox.setLayoutX(800);
        medkitBox.setLayoutY(435);
        root.getChildren().add(medkitBox);

        //Allows users to input the amount of firstkit they own
        //buttons are added to root here
        //Allows users to input the amount of firstkit they own
        Label firstkitCount = new Label("Firstkit: ");
        TextField textFirstkit = new TextField();
        textFirstkit.setPrefWidth(50);
        //Creates an event handler that stores the amount of medkit input by users
        textFirstkit.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //Users can press enter to input the firstkit
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        //Stores the amount of medkit
                        int firstkit = Integer.parseInt(textFirstkit.getText());
                        //Sets the amount of firstkit owned by the player
                        model.getPlayer().setFirstkit(firstkit);
                        System.out.println("Firstkit Count: " + firstkit);
                    } catch (NumberFormatException nf) {
                        //Warns users if their input is not an integer
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });

        //Adds the textfield to the interface
        HBox firstkitBox = new HBox();
        firstkitBox.getChildren().addAll(firstkitCount, textFirstkit);
        firstkitBox.setLayoutX(800);
        firstkitBox.setLayoutY(400);
        root.getChildren().add(firstkitBox);


        //Allows users to input the amount of drinks they own
        //buttons are added to root here
        //Allows users to input the amount of drinks they own
        Label drinksCount = new Label("Drinks: ");
        TextField textDrinks = new TextField();
        textDrinks.setPrefWidth(50);
        //Creates an event handler that stores the amount of drinks input by users
        textDrinks.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //Users can press enter to input the drinks
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        //Stores the amount of drinks
                        int drinks = Integer.parseInt(textDrinks.getText());
                        //Sets the amount of drinks owned by the player
                        model.getPlayer().setDrinks(drinks);
                        System.out.println("Drinks Count: " + drinks);
                    } catch (NumberFormatException nf) {
                        //Warns users if their input is not an integer
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });

        //Adds the textfield to the interface
        HBox drinksBox = new HBox();
        drinksBox.getChildren().addAll(drinksCount, textDrinks);
        drinksBox.setLayoutX(800);
        drinksBox.setLayoutY(365);
        root.getChildren().add(drinksBox);


        //buttons are added to root here
        //Allows users to input the amount of ammo they own for weapon1 at a particular time in the game
        Label ammo1Count = new Label("Ammo1: ");
        TextField text1 = new TextField();
        text1.setPrefWidth(50);
        //Creates an event handler that stores the amount of ammo input by users
        text1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //Users can press enter to input the ammo
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        //Stores the amount of ammo
                        int ammo = Integer.parseInt(text1.getText());
                        //Sets the amount of ammo1 owned by the player
                        model.getPlayer().setAmmo1(ammo);
                        System.out.println("Ammo1 Count: " + ammo);
                    } catch (NumberFormatException nf) {
                        //Warns users if their input is not an integer
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });

        //Adds the textfield to the interface
        HBox hBox = new HBox();
        hBox.getChildren().addAll(ammo1Count, text1);
        hBox.setLayoutX(800);
        hBox.setLayoutY(530);
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
                        //Sets the amount of ammo2 owned by the player
                        model.getPlayer().setAmmo2(ammo);
                        System.out.println("Ammo2 Count: " + ammo);
                    } catch (NumberFormatException nf) {
                        System.out.println("The input is not valid.");
                    }
                }
            }
        });
        //Puts the textfield on the interface
        HBox hbox = new HBox();
        hbox.getChildren().addAll(ammo2Count, text2);
        hbox.setLayoutX(800);
        hbox.setLayoutY(560);
        root.getChildren().add(hbox);


        //Checks if a user has vehicle at a particular time during the game
        //Creates a check box
        CheckBox checkbox = new CheckBox("Vehicle");
        //Checking check box indicates users do have a vehicle
        checkbox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkbox.isSelected()) {
                    //Tells the system that users do have a vehicle
                    model.getPlayer().setVehicle(true);
                } else {
                    model.getPlayer().setVehicle(false);
                }
            }
        });
        //Places the check box in the interface
        checkbox.setLayoutX(800);
        checkbox.setLayoutY(500);
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
        //Creates the scene that has width w, height h and white background color
        Scene scene = new Scene(root, w, h, Color.WHITE);//h
        //how big is the window?

        //Sets the scene
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void unToggle(){
        int[] toggleIndex = {0,1,2};
        for(Integer i: toggleIndex){
            ToggleButton tb = (ToggleButton) btnStackOne[i];
            tb.setSelected(false);
            //todo
        }

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

    //Main method
    public void run(String[] args) {
        launch(args);
    }
}

