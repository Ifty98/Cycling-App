package task3;

import java.io.File;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Task3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //creates a new BorderPane object named bPane
        BorderPane bPane = new BorderPane();

        // Top part
        //creates a hbox and add a horizontal spacing of 115 pixels between the elements inside 
        HBox hbox3 = new HBox();
        hbox3.setSpacing(115);
        //defines the path of an image file and creates a new ImageView object named imageView to display it
        String imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "white-bike-icon.png";
        String imageURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        //gets the current time and formats it as a string in the format "HH:mm:ss" 

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        //creates a hbox and adds two buttons to it
        HBox hbox1 = new HBox();
        //the first button displays the current time
        CustomButton button1 = new CustomButton(formattedTime, 100, 25);
        //adds a time line to update the time every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime now = LocalTime.now();
            String formattedTimeNow = now.format(formatter);
            button1.setText(formattedTimeNow);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        button1.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        //add backgound color to the button 
        button1.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        CustomButton button2 = new CustomButton("", 35, 25);
        //the second button displays a image of a bike icon
        button2.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        button2.setGraphic(imageView);
        //adds both buttons to the hbox1
        hbox1.getChildren().addAll(button1, button2);

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "network-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        //a hbox to display battery and network icon
        HBox hbox2 = new HBox();
        CustomButton button3 = new CustomButton("", 35, 25);
        button3.setGraphic(imageView);
        button3.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "battery-icon-6.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(15);
        imageView.setFitHeight(20);

        CustomButton button4 = new CustomButton("", 35, 25);
        button4.setGraphic(imageView);
        button4.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        hbox2.getChildren().addAll(button3, button4);

        hbox3.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        hbox3.getChildren().addAll(hbox1, hbox2);
        //using the bPane object, adds hbox3 to the top part of the layout
        bPane.setTop(hbox3);

        // Center part
        //creates a vertical box to add horizontal boxes inside 
        VBox vbox11 = new VBox();
        vbox11.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox11.setPadding(new Insets(5));
        vbox11.setSpacing(10);

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "white-cycling-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        // First row
        //creates a hbox to dispaly the dashboard and the navigate buttons
        HBox hbox11 = new HBox();
        hbox11.setSpacing(10);
        CustomButton button11 = new CustomButton("", 150, 150);
        Label label = new Label("Dashboard");
        label.setTextFill(Color.ALICEBLUE);
        StackPane stackPane = new StackPane(imageView, label);
        button11.setGraphic(stackPane);
        stackPane.setAlignment(imageView, Pos.CENTER);
        stackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        button11.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #00FFFF;");

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "nav-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        CustomButton button12 = new CustomButton("", 150, 150);
        label = new Label("Navigate");
        label.setTextFill(Color.ALICEBLUE);
        stackPane = new StackPane(imageView, label);
        button12.setGraphic(stackPane);
        stackPane.setAlignment(imageView, Pos.CENTER);
        stackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        button12.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #006400;");
        hbox11.getChildren().addAll(button11, button12);

        // Second row
        //creates a hbox to display the history and map butttons
        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "clock-event-history.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        HBox hbox22 = new HBox();
        hbox22.setSpacing(10);

        CustomButton button13 = new CustomButton("", 150, 150);
        label = new Label("History");
        label.setTextFill(Color.ALICEBLUE);
        stackPane = new StackPane(imageView, label);
        button13.setGraphic(stackPane);
        stackPane.setAlignment(imageView, Pos.CENTER);
        stackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        button13.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #FFA500;");

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "map-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);

        CustomButton button14 = new CustomButton("", 150, 150);
        label = new Label("Map");
        label.setTextFill(Color.ALICEBLUE);
        stackPane = new StackPane(imageView, label);
        button14.setGraphic(stackPane);
        stackPane.setAlignment(imageView, Pos.CENTER);
        stackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
        button14.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #800080;");

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "white-bike-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        button14.setOnAction((ActionEvent event) -> {
            String imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "hendon-area.png";
            String imageURI2 = Paths.get(imgPath2).toUri().toString();
            ImageView imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(320);
            imageView2.setFitHeight(480);

            bPane.setCenter(imageView2);
        });
        hbox22.getChildren().addAll(button13, button14);

        // Third row
        //creates a hbox to display the fitness and settings buttons
        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "fitness-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(70);
        imageView.setFitHeight(60);

        HBox hbox33 = new HBox();
        hbox33.setSpacing(10);

        CustomButton button15 = new CustomButton("", 150, 150);
        label = new Label("Fitness");
        label.setTextFill(Color.ALICEBLUE);
        stackPane = new StackPane(imageView, label);
        button15.setGraphic(stackPane);
        stackPane.setAlignment(imageView, Pos.CENTER);
        stackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        button15.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #FF0000;");
        //adds a event handler to the fitness button to change the center layout of the bpane
        button15.setOnAction((ActionEvent event) -> {
            VBox vbox41 = new VBox();
            vbox41.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            vbox41.setPadding(new Insets(5));
            vbox41.setSpacing(10);

            String imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "ruler-icon.png";
            String imageURI2 = Paths.get(imgPath2).toUri().toString();
            ImageView imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(70);
            imageView2.setFitHeight(70);

            // First row
            //creates a hbox to display the distance and time buttons
            HBox hbox41 = new HBox();
            hbox41.setSpacing(10);
            CustomButton button41 = new CustomButton("", 150, 150);
            Label label2 = new Label("Distance");
            label2.setTextFill(Color.BLACK);
            StackPane stackPane2 = new StackPane(imageView2, label2);
            button41.setGraphic(stackPane2);
            stackPane2.setAlignment(imageView2, Pos.CENTER);
            stackPane2.setAlignment(label2, Pos.BOTTOM_CENTER);
            stackPane2.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            button41.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #808080;");
            button41.setOnAction((ActionEvent event2) -> {
                VBox vbox7 = new VBox();
                vbox7.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                vbox7.setPadding(new Insets(10));
                vbox7.setSpacing(10);

                Label label71 = new Label("Distance (km)");
                label71.setTextFill(Color.BLACK);
                label71.setFont(new Font(20));
                //creates a text field to enter the distance
                TextField distance = new TextField();
                distance.setPrefHeight(40);

                Label label72 = new Label("Speed (km/h)");
                label72.setTextFill(Color.BLACK);
                label72.setFont(new Font(20));
                //creates a text field to enter the speed
                TextField speed = new TextField();
                speed.setPrefHeight(40);

                HBox hbox71 = new HBox();
                CustomButton button71 = new CustomButton("Go", 100, 50);
                button71.setStyle("-fx-background-color: #FF0000; -fx-text-fill: #F0F8FF; -fx-background-radius: 20; -fx-font-weight: bold; -fx-font-size: 20;");
                //checks if both text fields are empty to disable the go button
                button71.disableProperty().bind(Bindings.isEmpty(distance.textProperty()).or(Bindings.isEmpty(speed.textProperty())));
                Label label74 = new Label();
                Label label73 = new Label();
                button71.setOnAction((ActionEvent event4) -> {
                    calculateTime(distance, speed, label73);
                    label74.setText("Workout recorded");
                });
                hbox71.getChildren().addAll(button71);
                hbox71.setAlignment(Pos.CENTER);

                vbox7.getChildren().addAll(label71, distance, label72, speed, hbox71, label74, label73);
                bPane.setCenter(vbox7);
            });

            imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "stopwatch-icon.png";
            imageURI2 = Paths.get(imgPath2).toUri().toString();
            imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(70);
            imageView2.setFitHeight(70);

            CustomButton button42 = new CustomButton("", 150, 150);
            label2 = new Label("Time");
            label2.setTextFill(Color.BLACK);
            stackPane2 = new StackPane(imageView2, label2);
            button42.setGraphic(stackPane2);
            stackPane2.setAlignment(imageView2, Pos.CENTER);
            stackPane2.setAlignment(label2, Pos.BOTTOM_CENTER);
            stackPane2.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            button42.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #808080;");
            button42.setOnAction((ActionEvent event3) -> {
                VBox vbox7 = new VBox();
                vbox7.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                vbox7.setPadding(new Insets(10));
                vbox7.setSpacing(10);

                Label label71 = new Label("Time (hours:minutes)");
                label71.setTextFill(Color.BLACK);
                label71.setFont(new Font(20));
                //creates a text field to enter the time
                TextField time = new TextField();
                time.setPrefHeight(40);

                Label label72 = new Label("Speed (km/h)");
                label72.setTextFill(Color.BLACK);
                label72.setFont(new Font(20));
                //creates a text field to enter the speed
                TextField speed = new TextField();
                speed.setPrefHeight(40);

                HBox hbox71 = new HBox();
                CustomButton button71 = new CustomButton("Go", 100, 50);
                button71.setStyle("-fx-background-color: #FF0000; -fx-text-fill: #F0F8FF; -fx-background-radius: 20; -fx-font-weight: bold; -fx-font-size: 20;");
                //checks if both text fields are empty to disable the go button
                button71.disableProperty().bind(Bindings.isEmpty(time.textProperty()).or(Bindings.isEmpty(speed.textProperty())));
                Label label74 = new Label();
                Label label73 = new Label();
                button71.setOnAction((ActionEvent event4) -> {
                    calculateDistance(time, speed, label73);
                    label74.setText("Workout recorded");
                });
                hbox71.getChildren().addAll(button71);
                hbox71.setAlignment(Pos.CENTER);

                vbox7.getChildren().addAll(label71, time, label72, speed, hbox71, label74, label73);
                bPane.setCenter(vbox7);
            });
            hbox41.getChildren().addAll(button41, button42);

            // Second row
            //creates a hbox to display the calories and HR Zone buttons
            imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "calories-icon.png";
            imageURI2 = Paths.get(imgPath2).toUri().toString();
            imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(70);
            imageView2.setFitHeight(70);

            HBox hbox42 = new HBox();
            hbox42.setSpacing(10);

            CustomButton button43 = new CustomButton("", 150, 150);
            label2 = new Label("Calories");
            label2.setTextFill(Color.BLACK);
            stackPane2 = new StackPane(imageView2, label2);
            button43.setGraphic(stackPane2);
            stackPane2.setAlignment(imageView2, Pos.CENTER);
            stackPane2.setAlignment(label2, Pos.BOTTOM_CENTER);
            stackPane2.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            button43.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #808080;");

            imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "heart-rate-icon.png";
            imageURI2 = Paths.get(imgPath2).toUri().toString();
            imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(70);
            imageView2.setFitHeight(70);

            CustomButton button44 = new CustomButton("", 150, 150);
            label2 = new Label("HR Zone");
            label2.setTextFill(Color.BLACK);
            stackPane2 = new StackPane(imageView2, label2);
            button44.setGraphic(stackPane2);
            stackPane2.setAlignment(imageView2, Pos.CENTER);
            stackPane2.setAlignment(label2, Pos.BOTTOM_CENTER);
            stackPane2.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            button44.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #808080;");

            hbox42.getChildren().addAll(button43, button44);

            // Third row
            //creates a hbox to display the power zone and stop buttons
            imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "power-icon.png";
            imageURI2 = Paths.get(imgPath2).toUri().toString();
            imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(70);
            imageView2.setFitHeight(60);

            HBox hbox43 = new HBox();
            hbox43.setSpacing(10);

            CustomButton button45 = new CustomButton("", 150, 150);
            label2 = new Label("Power Zone");
            label2.setTextFill(Color.BLACK);
            stackPane2 = new StackPane(imageView2, label2);
            button45.setGraphic(stackPane2);
            stackPane2.setAlignment(imageView2, Pos.CENTER);
            stackPane2.setAlignment(label2, Pos.BOTTOM_CENTER);
            stackPane2.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            button45.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #808080;");

            imgPath2 = System.getProperty("user.dir")
                    + File.separator + "images"
                    + File.separator + "stop-icon.png";
            imageURI2 = Paths.get(imgPath2).toUri().toString();
            imageView2 = new ImageView(new Image(imageURI2));
            imageView2.setFitWidth(70);
            imageView2.setFitHeight(60);

            CustomButton button46 = new CustomButton("", 150, 150);
            label2 = new Label("Stop");
            label2.setTextFill(Color.BLACK);
            stackPane2 = new StackPane(imageView2, label2);
            button46.setGraphic(stackPane2);
            stackPane2.setAlignment(imageView2, Pos.CENTER);
            stackPane2.setAlignment(label2, Pos.BOTTOM_CENTER);
            stackPane2.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            button46.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #808080;");
            hbox43.getChildren().addAll(button45, button46);

            vbox41.getChildren().addAll(hbox41, hbox42, hbox43);
            //sets this vbox in the bottom part of the layout
            bPane.setCenter(vbox41);
        });

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "gear-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));
        imageView.setFitWidth(70);
        imageView.setFitHeight(60);

        CustomButton button16 = new CustomButton("", 150, 150);
        label = new Label("Settings");
        label.setTextFill(Color.ALICEBLUE);
        stackPane = new StackPane(imageView, label);
        button16.setGraphic(stackPane);
        stackPane.setAlignment(imageView, Pos.CENTER);
        stackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        button16.setStyle("-fx-font-weight: bold; -fx-background-radius: 10; -fx-background-color: #DEB887;");
        hbox33.getChildren().addAll(button15, button16);

        vbox11.getChildren().addAll(hbox11, hbox22, hbox33);

        bPane.setCenter(vbox11);

        // Bottom part
        //creates hbox with a button with the back icon
        HBox hbox35 = new HBox();

        imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + "back-icon.png";
        imageURI = Paths.get(imgPath).toUri().toString();
        imageView = new ImageView(new Image(imageURI));

        CustomButton button35 = new CustomButton("", 35, 25);
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);
        button35.setGraphic(imageView);
        hbox35.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        button35.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        //adds a event handler to the back button to display again the start page
        button35.setOnAction((ActionEvent event) -> {
            bPane.setCenter(vbox11);
        });
        hbox35.getChildren().addAll(button35);
        //sets this hbox in the bottom part of the layout
        bPane.setBottom(hbox35);

        // Display scene
        Scene scene1 = new Scene(bPane, 320, 530);
        primaryStage.setTitle("Cycle");
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
   
    //gets the distance and speed from the text fields and calculates the time 
    public void calculateTime(TextField distance, TextField speed, Label finalResult) {
        double num1 = Double.parseDouble(distance.getText());
        double num2 = Double.parseDouble(speed.getText());
        double result = num1 / num2;
        double resultMinutes = result * 60;
        int hours = (int) resultMinutes / 60;
        int minutes = (int) resultMinutes % 60;

        finalResult.setText("Estimated time: " + hours + " hour(s) and " + minutes + " minutes ");
    }
    //gets the time and speed from the text fields and calculates the distance
    public void calculateDistance(TextField time, TextField speed, Label finalResult) {
        String timeString = time.getText();
        String[] parts = timeString.split(":");
        double hours = Double.parseDouble(parts[0]);
        double minutes = Double.parseDouble(parts[1]);
        double getTime = hours + minutes / 60.0;
        double getSpeed = Double.parseDouble(speed.getText());

        double result = getTime * getSpeed;
        finalResult.setText("Estimated distance " + result + " Km");
    }
}
