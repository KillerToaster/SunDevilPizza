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

public class StudentLogin extends BorderPane
{
    //header vars
    private Label appTitle;
    private Image logoIMG;
    private HBox headerBox;
    private ImageView logoView;

    //body vars
    private Label pageTitle, idLabel, choiceLabel;
    private TextField idInputField;
    private Button loginButton, newOrderButton;
    //body boxes
    private VBox bodyLayout;
    private HBox loginBox;
    private VBox inputBox;

    public StudentLogin() throws IOException
    {
        //intitialize the app header
        appTitle = new Label("SunDevil Pizza");


        //create header image
        //InputStream stream = new FileInputStream("INSERT FILE NAME HERE");
        //logoIMG = new Image(stream);
        //logoView = new ImageView();
        //logoView.setImage(logoIMG);
        //logoView.setPreserveRatio(true);


        //place label and image into header
        headerBox = new HBox();
        headerBox.getChildren().addAll(logoView, appTitle);
        //set color
        //headerBox.setBackground(new Background(new BackgroundFill(Color.RED))); //come back to this
        this.setTop(headerBox);

        //create login body
        bodyLayout = new VBox();
        pageTitle = new Label("Please Enter Your ID To Check On Order Status:");
        loginBox = new HBox();
        idLabel = new Label("ASURITE ID:");
        inputBox = new VBox();
        idInputField = new TextField();
        idInputField.setPromptText("ENTER 10 DIGIT ID HERE");
        loginButton = new Button("SUBMIT");
        choiceLabel = new Label("-OR-");
        newOrderButton = new Button("NEW ORDER");

        //put nodes onto scene
        inputBox.getChildren().addAll(idInputField, loginButton, choiceLabel, newOrderButton);
        loginBox.getChildren().addAll(idLabel, inputBox);
        bodyLayout.getChildren().addAll(pageTitle, loginBox);
        this.setCenter(bodyLayout);
    }

}
