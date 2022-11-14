//  Phase #: 3
//  Names: Andrew Gantner, Majid Ghasib, Kelvin Tran, Jimmy Phan, Isabella Hutchinson
//  Group #: 35
//  Lecture: 9:00 - 10:15 AM TH
//  Description: This is the driver class for this application

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{

    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage.setTitle("SunDevil Pizza");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/pizzaSlice.png")));
        stage.show();
    }

    public static void main(String[] args)
    {

        launch(args);
    }
}
