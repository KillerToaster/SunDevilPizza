


//clean up these import statements
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

    //EmployeeLogin page nodes
    @FXML
    TextField employeeIDField;
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

    //OrderProcessingAgentView nodes
    VBox orderBox;
    Button readyToCookButton, deleteButton;

    //ChefView nodes
    VBox chefOrderBox;
    Button cookingButton, readyButton;

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

    //this method checks if an employee is valid and then takes them to the correct order page
    public void handleEmployeeLogin() throws Exception
    {
        //if id from employeeIDField is valid login
        Integer val1 = Integer.valueOf(employeeIDField.getText());
        if (val1 == 1)
        {
            Parent root = FXMLLoader.load(getClass().getResource("ChefView.fxml"));
            Stage newStage = (Stage) (employeeIDField.getScene().getWindow());
            newStage.setScene(new Scene(root, 700, 500));
        }
        else if (val1 == 2)
        {
            Parent root = FXMLLoader.load(getClass().getResource("OrderProcessingAgentView.fxml"));
            Stage newStage = (Stage) (employeeIDField.getScene().getWindow());
            newStage.setScene(new Scene(root, 700, 500));
        }
        //else outline employeeIDField in red and change prompt text to "PLEASE ENTER A VALID ID"
        //there are two employee types. log them in accordingly
        else
        {
            employeeIDField.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            employeeIDField.setText("");
            employeeIDField.setPromptText("PLEASE ENTER A VALID ID");
        }
    }

    //this method removed the red border when the user clicks back on the text field if they previously input an invalid ID
    public void handleIDFieldOnMouseClicked() throws Exception
    {
        employeeIDField.setStyle("-fx-border-width: 0px");
    }

    //============================
    //Handle StudentLogin actions
    //============================

    //this method checks if the student is valid and then sends them to the check order page if true
    public void handleCheckOrders() throws Exception
    {
        //check if id is valid

        //if valid go to StudentOrderStatus
    }

    //this method sends the student to a new order form
    public void handleNewOrder() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("OrderPizza.fxml")); //not working... idk why
        Stage newStage = (Stage) (sNewOrderButton.getScene().getWindow());  //this line is throwing an error :/
        newStage.setScene(new Scene(root, 700, 500));
    }


    //============================
    //Handle OrderPizza actions
    //============================

    //this method manages the state of the pizza type
    public void handlePizzaType()
    {
        //only one of the radio buttons can be selected at a time
    }

    //this method manages the state of the checkboxes
    public void handlePizzaToppings()
    {
        //anywhere between 0-4 toppings
    }

    //this method checks the validity of an order and submits it to the system accordingly
    //must update other scenes and database
    public void handleOrderSubmit() throws Exception
    {
        //if the student id is not valid change the textfield red and change the prompt

        //else change the scene and put the order in the order database
        Parent root = FXMLLoader.load(getClass().getResource("OrderSuccessful.fxml"));
        Stage newStage = (Stage) (poSubmitButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    //==============================
    //Handle OrderSuccessful actions
    //==============================

    //This method returns the user to the homepage
    public void handleReturnHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        Stage newStage = (Stage) (ossReturnButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    //=======================================
    //Handle OrderProcessingAgentView actions
    //=======================================

    // This page needs to be populated dynamically by Pizza objects
    // (most likely stored in an ArrayList upon initialization)
    // this needs to be javaFX code based on how the database is written

    //the order processing agent actor can delete any order from the queue

    //the GUI should populate using check boxes
    //when the box is checked, the order can be changed using buttons
    //VBox for orders is called orderBox

    //this button changes the selected orders' status from accepted to ready to cook
    public void handleOrderProcess()
    {

    }

    //this button can delete an order from the system at any time.
    //only the OrderProcessingAgent can delete orders
    //only way to remove an order from the system
    public void handleOrderDelete()
    {

    }


    //=======================================
    //Handle OrderChefView actions
    //=======================================

    // This page needs to be populated dynamically by Pizza objects
    // (most likely stored in an ArrayList upon initialization)
    // this needs to be javaFX code based on how the database is written

    //the chef is the actor which completes the order and sends the email
    //to simulate this, use a dialog box that simply says: "Email sent to customer #: [ASURITE ID]"

    //the GUI should populate using check boxes
    //when the box is checked, the order can be changed using buttons
    //VBox is called chefOrderBox

    //this button turns the selected orders from ready to cook into cooking
    public void handleCooking()
    {

    }

    //this button changes the selected orders from cooking to ready
    public void handleReady()
    {

    }


}
