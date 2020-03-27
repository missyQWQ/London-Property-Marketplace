import java.util.*;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This is the login class.
 * End user can signup a account and login to the account. 
 */
public class Login extends Application
{
    private LoginControl login;
    private SignupControl signup;
    private ForgetControl forget;
    private Stage stage;
    //width and height
    private final double WIDTH = 400.0;
    private final double HEIGHT = 260.0;
    private Validity validity = Validity.getInstance();
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * set up the stage.
     */
    @Override
    public void start(Stage mainStage)
    {
        try{
            stage = mainStage;
            stage.setOpacity(0.95);
            stage.setTitle("Login");
            stage.setMinWidth(WIDTH);
            stage.setMinHeight(HEIGHT);
            Startlogin();
            stage.show();
        }
        catch(Exception e){
            System.out.println("Open new page failed");
        }
    }

    /**
     * load the fxml file for logging.
     */
    public void Startlogin(){
        try {
            login = (LoginControl) initializeScene("./fxml/login.fxml");
            login.setApp(this);
        } catch(Exception ex){
            System.out.println("Doesn't find the directory and resource");
        }
    }

    /**
     * load the fxml file for finding password.
     */
    public void StartFindPassword(){
        try {
            forget = (ForgetControl) initializeScene("./fxml/Forget.fxml");
            forget.setApp(this);
        } catch(Exception ex){
            System.out.println("Doesn't find the directory and resource");
        }
    }

    /**
     * load the fxml file for signing up.
     */
    public void Startsignup(){
        try {
            signup = (SignupControl) initializeScene("./fxml/Signup.fxml");
            signup.setApp(this);
        } catch(Exception ex){
            System.out.println("Doesn't find the directory and resource");
        }
    }

    /**
     * Used when the account has been registered.
     * Back to the log in page.
     */
    public void Continue(HashMap<String, String> info)
    {
        validity.Store_Info(info);
        Startlogin();
    }

    /**
     * Used when the end user clicks "back" button.
     * Back to the log in page.
     */
    public void Back()
    {
        Startlogin();
    }

    /**
     * Check if the information is correct,
     * Clear the text field if the information is incorrect.
     */
    public void logging(String username,String password){
        if(validity.CheckInfo(username,password)){
            Start start = new Start();
            try {
                start.start(stage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.valueOf("ERROR"),"Incorrect username or password! Please try again.");                       
            alert.show();
            login.Clear();
        }
    }

    /**
     * Check if the address refers to the correct email address,
     * Clear the text field if the information is incorrect.
     */
    public void comparing(String username,String address){
        if(validity.CheckForget(username,address)){
            Startlogin();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.valueOf("ERROR"),"Incorrect username or address! Please try again.");                       
            alert.show();
            forget.Clear();
        }
    }

    /**
     * find the fxml file and display it.
     */
    private Initializable initializeScene(String fxml) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader();
        InputStream in = Login.class.getResourceAsStream(fxml);
        fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
        fxmlloader.setLocation(Login.class.getResource(fxml));
        AnchorPane Log = new AnchorPane();
        try {
            Log = (AnchorPane) fxmlloader.load(in);
        } 
        catch(IOException ex){
            System.out.println("Doesn't find the directory and resource");
        }

        if(fxml=="./fxml/login.fxml"){ 
            Scene scene = new Scene(Log, WIDTH, HEIGHT);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
        }
        else if(fxml=="./fxml/Forget.fxml"){ 
            Scene scene = new Scene(Log, 490, 210);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
        }
        else{
            Scene scene = new Scene(Log, 370, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
        }
        return (Initializable) fxmlloader.getController();
    }

    /**
     * link to the guestpanel;
     */
    //public void gotoApp(){
    //    AppWindow mainWindow = new AppWindow();
    //    mainWindow.start(stage);
    //}
}
