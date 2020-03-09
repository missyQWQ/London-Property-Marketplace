import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
// import javafx.fxml.FXML;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.control.*;

/**
 * Write a description of JavaFX class Start here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Statistics extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        URL url = getClass().getResource("./fxml/Statistics.fxml");
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        
        stage.setTitle("Statistics");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}