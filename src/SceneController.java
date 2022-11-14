//  Phase #: 3
//  Names: Andrew Gantner, Majid Ghasib, Kelvin Tran, Jimmy Phan, Isabella Hutchinson
//  Group #: 35
//  Lecture: 9:00 - 10:15 AM TH
//  Description: This is the controller class for all interactions


//clean up these import statements
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.control.*;
import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.layout.*;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
//import java.nio.file;

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

    @FXML
    ToggleGroup type;

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

    //studentview nodes
    @FXML VBox studentOrderBox;
    @FXML Button sosHome;

    //=======================
    //Handle HomePage actions
    //=======================

    //When the user clicks "employee" go to EmployeeLogin
    public void hpEmployeeHandler() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogin.fxml"));
        Stage newStage = (Stage) (hpEmployeeButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 600, 400));
    }

    //when the user clicks "student" go to StudentLogin
    public void hpStudentHandler() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("StudentLogin.fxml"));
        Stage newStage = (Stage) (hpStudentButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 600, 400));
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
            newStage.setScene(new Scene(root, 600, 400));

            //Here populate the ChefView scene with orders that the chef can mutate
            //if orderStatus = "ready to cook" or "Cooking" then the chef can change them
            //populate view with their orders from the log.txt
            //create an ArrayList of objects from log.txt

            //print out order text
            TextArea orderTextArea = new TextArea("");

            //create order list here
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("log.txt"));
                String line = reader.readLine();
                while (line != null) {
                    orderTextArea.appendText(line);
                    orderTextArea.appendText("\n");
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            orderTextArea.setEditable(false);
            orderTextArea.setPrefSize(300, 300);
            ((BorderPane) root).setCenter(orderTextArea);

        }
        if (isNumeric(employeeID) && employeeID.charAt(0) == '2')//if id is type order processing agent
        {
            Parent root = FXMLLoader.load(getClass().getResource("OrderProcessingAgentView.fxml"));
            Stage newStage = (Stage) (employeeIDField.getScene().getWindow());
            newStage.setScene(new Scene(root, 600, 400));

            //here, populate the AgentView with all orders, because this agent has more control
            //populate view with their orders from the log.txt
            //create an ArrayList of objects from log.txt

            //print out order text
            TextArea orderTextArea = new TextArea("");

            //create order list here
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("log.txt"));
                String line = reader.readLine();
                while (line != null) {
                    orderTextArea.appendText(line);
                    orderTextArea.appendText("\n");
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            orderTextArea.setEditable(false);
            orderTextArea.setPrefSize(300, 300);
            ((BorderPane) root).setCenter(orderTextArea);

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
        newStage.setScene(new Scene(root, 600, 400));
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
            Parent root = FXMLLoader.load(getClass().getResource("StudentOrderView.fxml"));
            Stage newStage = (Stage) (sSubmitButton.getScene().getWindow());
            newStage.setScene(new Scene(root, 600, 400));

            TextArea orderTextArea = new TextArea("");
            //add the order
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("log.txt"));
                String line = reader.readLine();
                while (line != null) {
                    String firstTenChars = line.substring(0, 10);
                    System.out.println("First Ten: " + firstTenChars);
                    System.out.println("ASURITE: " + ASURITE);
                    if (firstTenChars.equals(ASURITE)) {
                        orderTextArea.appendText(line);
                        orderTextArea.appendText("\n");
                    }
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            orderTextArea.setEditable(false);
            orderTextArea.setPrefSize(300, 300);
            ((BorderPane) root).setCenter(orderTextArea);

            newStage.show();

        }
        else {
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
        newStage.setScene(new Scene(root, 600, 400));
    }

    public void handleSLoginHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage2 = (Stage) (studentLoginHome.getScene().getWindow());
        newStage2.setScene(new Scene(root, 600, 400));
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

        if (ASURITE.length() == 10 && isNumeric(ASURITE))
        {
            ToggleButton selectedToggleButton = (ToggleButton) type.getSelectedToggle();

            //create a new PizzaOrder object
            //add that pizza object to the list of objects in log.txt

            Write(ASURITE, selectedToggleButton.getText(), getToppings());

            Parent root = FXMLLoader.load(getClass().getResource("OrderSuccessful.fxml"));
            Stage newStage = (Stage) (poSubmitButton.getScene().getWindow());
            newStage.setScene(new Scene(root, 600, 400));
        }
        else
        {
            poASURITE.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            poASURITE.setText("");
            poASURITE.setPromptText("PLEASE ENTER A VALID ID");
        }
    }


    public String getToppings()
    {
        String toppings = "";
        if (mushroomButton.isSelected())
        {
            toppings = toppings +"mushroom ";
        }

        if (oliveButton.isSelected())
        {
            toppings = toppings +"olive ";
        }

        if (onionButton.isSelected())
        {
            toppings = toppings +"onion ";
        }

        if (extraCheeseButton.isSelected())
        {
            toppings = toppings +"extraCheese ";
        }

        return toppings;
    }

    //Checks whether an input is Numeric
    public static boolean isNumeric(String string)
    {
        float value;

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            value = Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    public void handlePOHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (oReturnHome.getScene().getWindow());
        newStage.setScene(new Scene(root, 600, 400));
    }

    //==============================
    //Handle OrderSuccessful actions
    //==============================

    //This method returns the user to the homepage
    public void handleReturnHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (ossReturnButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 600, 400));
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
        newStage.setScene(new Scene(root, 600, 400));
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
        //go through ArrayList and change fields of the selected orders
        //all info should be saved back to log.txt each time
    }

    //this button changes the selected orders from cooking to ready
    public void handleReady()
    {
        //go through array list and change selected orders from cooking to ready
        //open a dialog box that says email sent to orders: [list of id numbers]
        //all info should be saved back to log.txt each time
    }

    public void handleChefHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (chefViewHome.getScene().getWindow());
        newStage.setScene(new Scene(root, 600, 400));
    }


    public void handleSOSHome() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage newStage = (Stage) (sosHome.getScene().getWindow());
        newStage.setScene(new Scene(root, 600, 400));
    }

    //=======================================
    //Other Methods
    //=======================================

    public void Write(String ASURITE, String types, String toppings)
    {
        File log = new File("log.txt");
        try{
            if(log.exists()==false){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(ASURITE + " " + types + " " + toppings + "accepted" + "\n");
            out.close();
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }
    }
}
