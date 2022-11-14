import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        stage.setScene(new Scene(root, 700, 500));
        stage.setResizable(false);
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/pizzaSlice.png")));
        stage.show();
    }

    public static void main(String[] args)
    {
        List<PizzaOrder> list = new ArrayList<PizzaOrder>();
        launch(args);
    }
}
