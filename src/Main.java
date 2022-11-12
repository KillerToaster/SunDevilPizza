
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.* ;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.* ; // Point2D
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;

public class Main extends Application
{
    //declare all scenes
    private EmployeeLogin employeeLogin;
    private HomePage homePage;
    private EmployeeOrderStatus employeeOrderStatus;
    private OrderPizza orderPizza;
    private StudentLogin studentLogin;
    private StudentOrderStatus studentorderStatus;


    public void start(Stage stage)
    {
        StackPane root = new StackPane();
        homePage = new HomePage();
        root.getChildren().add(employeeLogin);

        Scene scene = new Scene(root, 700, 700);
        stage.setResizable(false);
        stage.setTitle("SunDevilPizza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {

        launch(args);
    }
}
