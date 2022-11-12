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

public class HomePage extends BorderPane
{
    //header vars
    private Label appTitle;
    private Image logoIMG;
    private HBox headerBox;
    private ImageView logoView;

    //body vars
    private Label pageTitle;
    private Button employeeButton, studentButton;
    private VBox bodyLayout;
    private HBox buttonBox;

    public HomePage() throws IOException
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

        //set up body
        bodyLayout = new VBox();
        pageTitle = new Label("Are you an employee or a student?");
        buttonBox = new HBox();
        employeeButton = new Button("Employee"); //when clicked scene changes to EmployeeLogin
        studentButton = new Button("Student"); //when clicked scene changes to StudentLogin

        //put nodes in the layout
        buttonBox.getChildren().addAll(employeeButton, studentButton);
        bodyLayout.getChildren().addAll(pageTitle, buttonBox);
    }
}
