//all event handling goes here

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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

import java.io.IOException;

public class SceneController
{
    //Home Page nodes
    @FXML
    Button hpEmployeeButton, hpStudentButton;
    TextField employeeIDField;

    //EmployeeLogin page nodes
    @FXML
    Button employeeLoginButton;

    //StudentLogin page nodes
    @FXML
    TextField sIDField;
    Button sSubmitButton, sNewOrderButton;

    //PizzaOrderPage nodes
    @FXML
    TextField poASURITE;
    RadioButton cheeseButton, pepperoniButton, veggieButton;
    CheckBox mushroomButton, oliveButton, onionButton, extraCheeseButton;
    Button poSubmitButton;

    //OrderSuccessful
    @FXML
    Button ossReturnButton;

    //=======================
    //Handle HomePage actions
    //=======================

    //When the user clicks "employee" go to EmployeeLogin
    public void hpEmployeeHandler() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogin.fxml"));

        Stage newStage = (Stage) (hpEmployeeButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    //when the user clicks "student" go to StudentLogin
    public void hpStudentHandler() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("StudentLogin.fxml"));
        Stage newStage = (Stage) (hpStudentButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    //============================
    //Handle EmployeeLogin actions
    //============================

    public void handleEmployeeLogin() throws Exception
    {
        //if id from employeeIDField is valid login
        //else outline employeeIDField in red and change prompt text to "PLEASE ENTER A VALID ID"
        //there are two employee types. log them in accordingly
        return;
    }

    //============================
    //Handle StudentLogin actions
    //============================

    public void handleCheckOrders() throws Exception
    {
        //check if id is valid

        //if valid go to StudentOrderStatus
    }

    public void handleNewOrder() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("OrderPizza.fxml"));
        Stage newStage = (Stage) (sNewOrderButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }


    //============================
    //Handle OrderPizza actions
    //============================

    public void handlePizzaType()
    {
        //only one of the radio buttons can be selected at a time
    }

    public void handlePizzaToppings()
    {
        //anywhere between 0-4 toppings
    }

    public void handleOrderSubmit() throws Exception
    {
        //if the student id is not valid change the textfield red and change the prompt

        //else change the scene and put the order in the order database
        Parent root = FXMLLoader.load(getClass().getResource("OrderSuccessful.fxml"));
        Stage newStage = (Stage) (poSubmitButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    //============================
    //Handle OrderSuccessful actions
    //============================

    public void handleReturnHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        Stage newStage = (Stage) (ossReturnButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

}
