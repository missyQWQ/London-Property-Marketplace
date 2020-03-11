import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Write a description of JavaFX class Start here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Start extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        URL url = getClass().getResource("./fxml/welcome.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}