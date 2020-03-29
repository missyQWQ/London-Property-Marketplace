import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

/**
 * This is the controller of login.fxml.
 * 
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class LoginControl implements Initializable
{
    //text field
    @FXML private  TextField username;
    @FXML private  PasswordField password;
    //button
    @FXML private  Button LOGIN;
    @FXML private  Button SIGNUP;
    // Hyperlink.
    private Hyperlink Forget;
    private Login login;
    
    /**
     * Set the login panel to current login panel.
     * @param login
     */
    public void setApp(Login login){
        this.login = login;
    }
    
    /**
     * Login the account
     * @param e The action event.
     */
    @FXML
    public void Login(ActionEvent e) {
        login.logging(username.getText(), password.getText());
    }
    
    /**
     * Signup the account
     * @param e The action event.
     */
    @FXML
    private void SignUp(ActionEvent event) {
        login.Startsignup();
    }

    /**
     * Clear the username and password textfield.
     */
    public void Clear() {
        username.setText(null);
        password.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
}
