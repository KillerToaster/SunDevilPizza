import java.util.ArrayList;

import javafx.scene.control.*;
import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class OrderPizza extends BorderPane
{
    //header vars
    private Label appTitle;
    private Image logoIMG;
    private HBox headerBox;
    private ImageView logoView;

    //body nodes
    private VBox bodyLayout, types, toppings;
    private HBox idBox, pizzaTypeBox, toppingsBox;
    private Label pageTitle, idLabel, typeLabel, toppingsLabel;
    private TextField idField;
    private RadioButton cheeseButton, pepperoniButton, veggieButton;
    private ToggleGroup typeGroup;
    private CheckBox mushroomButton, olivesButton, onionButton, extraCheeseButton;
    private Button submitButton;



    public OrderPizza() throws IOException
    {
        //intitialize the app header
        appTitle = new Label("SunDevil Pizza");
        //create header image
        InputStream stream = new FileInputStream("INSERT FILE NAME HERE");
        logoIMG = new Image(stream);
        logoView = new ImageView();
        logoView.setImage(logoIMG);
        logoView.setPreserveRatio(true);
        //place label and image into header
        headerBox = new HBox();
        headerBox.getChildren().addAll(logoView, appTitle);
        //set color
        //headerBox.setBackground(new Background(new BackgroundFill(Color.RED))); //come back to this
        this.setTop(headerBox);

        //set up body nodes
        bodyLayout = new VBox();
        pageTitle = new Label("Please Enter the Details of Your Order:");

        idBox = new HBox();
        idLabel = new Label("ASURITE ID:");
        idField = new TextField();
        idField.setPromptText("ENTER 10 DIGIT ID HERE");

        pizzaTypeBox = new HBox();
        typeLabel = new Label("Pizza Type:");
        types = new VBox();
        cheeseButton = new RadioButton("Cheese");
        pepperoniButton = new RadioButton("Pepperoni");
        veggieButton = new RadioButton("Vegetable");
        cheeseButton.setToggleGroup(typeGroup);
        pepperoniButton.setToggleGroup(typeGroup);
        veggieButton.setToggleGroup(typeGroup);
        cheeseButton.setSelected(true); //set the default to cheese

        toppingsBox = new HBox();
        toppingsLabel = new Label("Pizza Toppings:");
        toppings = new VBox();
        mushroomButton = new CheckBox("Mushroom");
        olivesButton = new CheckBox("Olives");
        onionButton = new CheckBox("Onion");
        extraCheeseButton = new CheckBox("Extra Cheese");

        submitButton = new Button("SUBMIT");

        //put all nodes into the layout
        idBox.getChildren().addAll(idLabel, idField);
        types.getChildren().addAll(cheeseButton, pepperoniButton, veggieButton);
        pizzaTypeBox.getChildren().addAll(typeLabel, types);
        toppings.getChildren().addAll(mushroomButton, olivesButton, onionButton, extraCheeseButton);
        toppingsBox.getChildren().addAll(toppingsLabel, toppings);
        bodyLayout.getChildren().addAll(pageTitle, idBox, pizzaTypeBox, toppingsBox, submitButton);
        this.setCenter(bodyLayout);
    }

}
