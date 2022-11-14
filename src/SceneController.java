


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
    @FXML
    Button employeeLoginButton, employeeLoginHome;

    //StudentLogin page nodes
    @FXML
    TextField sIDField;
    @FXML
    Button sSubmitButton, sNewOrderButton, studentLoginHome;

    //PizzaOrderPage nodes
    @FXML
    TextField poASURITE;
    @FXML
    RadioButton cheeseButton, pepperoniButton, veggieButton;
    @FXML
    CheckBox mushroomButton, oliveButton, onionButton, extraCheeseButton;
    @FXML
    Button poSubmitButton, poReturnHome;

    //OrderSuccessful
    @FXML
    Button ossReturnButton;

    @FXML
    Button oReturnHome;

    //OrderProcessingAgentView nodes
    @FXML
    VBox orderBox;
    @FXML
    Button readyToCookButton, deleteButton, opaHome;

    //ChefView nodes
    @FXML
    VBox chefOrderBox;
    @FXML
    Button cookingButton, readyButton, chefViewHome;

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
        String employeeID = employeeIDField.getText();
        //if id is type chef
        if (isNumeric(employeeID) && employeeID.charAt(0) == '1')
        {
            Parent root = FXMLLoader.load(getClass().getResource("ChefView.fxml"));
            Stage newStage = (Stage) (employeeIDField.getScene().getWindow());
            newStage.setScene(new Scene(root, 700, 500));
        }
        if (isNumeric(employeeID) && employeeID.charAt(0) == '2')//if id is type order processing agent
        {
            Parent root = FXMLLoader.load(getClass().getResource("OrderProcessingAgentView.fxml"));
            Stage newStage = (Stage) (employeeIDField.getScene().getWindow());
            newStage.setScene(new Scene(root, 700, 500));
        }
        else
        {
            //else outline employeeIDField in red and change prompt text to "PLEASE ENTER A VALID ID"
            //there are two employee types. log them in accordingly
            employeeIDField.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            employeeIDField.setText("");
            employeeIDField.setPromptText("PLEASE ENTER A VALID ID");
        }
    }

    //this method removed the red border when the user clicks back on the text field if they previously input an invalid ID
    public void handleEmployeeIDFieldOnMouseClicked() throws Exception
    {
        employeeIDField.setStyle("-fx-border-width: 0px");
    }
    public void handlesIDFieldOnMouseClicked() throws Exception
    {
        sIDField.setStyle("-fx-border-width: 0px");
    }

    //returns user to the home page
    public void handleELoginHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (employeeLoginHome.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    //============================
    //Handle StudentLogin actions
    //============================

    //this method checks if the student is valid and then sends them to the check order page if true
    public void handleCheckOrders() throws Exception
    {
        //if the student id is not valid change the textfield red and change the prompt
        String ASURITE = sIDField.getText();

        if (ASURITE.length() == 10 && isNumeric(ASURITE)) {
            Parent root = FXMLLoader.load(getClass().getResource("StudentOrderStatus.fxml"));
            Stage newStage = (Stage) (sSubmitButton.getScene().getWindow());
            newStage.setScene(new Scene(root, 700, 500));
        } else {
            sIDField.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            sIDField.setText("");
            sIDField.setPromptText("PLEASE ENTER A VALID ID");
        }
    }

    //this method sends the student to a new order form
    public void handleNewOrder() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("OrderPizza.fxml"));
        Stage newStage = (Stage) (sIDField.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    public void handleSLoginHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage2 = (Stage) (studentLoginHome.getScene().getWindow());
        newStage2.setScene(new Scene(root, 700, 500));
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
        String ASURITE = poASURITE.getText();

        if (ASURITE.length() == 10 && isNumeric(ASURITE)) {
            Parent root = FXMLLoader.load(getClass().getResource("OrderSuccessful.fxml"));
            Stage newStage = (Stage) (poSubmitButton.getScene().getWindow());
            newStage.setScene(new Scene(root, 700, 500));
        } else {
            poASURITE.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            poASURITE.setText("");
            poASURITE.setPromptText("PLEASE ENTER A VALID ID");
        }
    }

    //Checks whether an input is Numeric
    public static boolean isNumeric(String string)
    {
        int value;

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            value = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    public void handlePOHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (oReturnHome.getScene().getWindow());
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

    public void handleOPAHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (opaHome.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
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

    public void handleChefHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (chefViewHome.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }
}
