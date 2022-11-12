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

    @FXML
    Button hpEmployeeButton, hpStudentButton;

    //Handle HomePage actions

    public void hpEmployeeHandler() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogin.fxml"));

        Stage newStage = (Stage) (hpEmployeeButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

    public void hpStudentHandler() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("StudentLogin.fxml"));

        Stage newStage = (Stage) (hpStudentButton.getScene().getWindow());
        newStage.setScene(new Scene(root, 700, 500));
    }

}
