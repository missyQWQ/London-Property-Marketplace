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
     * set the login panel to current login panel.
     */
    public void setApp(Login login){
        this.login = login;
    }
    /**
     * jump to the forgetpassword panel.
     */
    @FXML void ForgetPass(ActionEvent event){
        login.StartFindPassword();
    }
    /**
     * login the account
     */
    @FXML
    public void Login(ActionEvent event) {
        login.logging(username.getText(), password.getText());
    }
    /**
     * signup the account
     */
    @FXML
    private void SignUp(ActionEvent event) {
        login.Startsignup();
    }

    /**
     * clear the username and password textfield.
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
