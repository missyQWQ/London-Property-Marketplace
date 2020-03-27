import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * This is the controller of forgetpassword panel.
 * 
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class ForgetControl implements Initializable
{
    //text field
    @FXML private TextField username;
    @FXML private TextField Email;
    //buttons
    @FXML private Button Continue;
    @FXML private Button Back;
     //Label
    @FXML private  Label User;
    @FXML private  Label Mail;
    private Login login;
    
    /**
     * Set the login panel to current login panel.
     * @param login
     */
    public void setApp(Login login){
        this.login = login;
    }
    
    /**
     * Send the the password to the mailbox if the information is correct.
     * @param e The action event.
     */
    @FXML
    private void Find_Password(ActionEvent e){
        login.comparing(username.getText(),Email.getText());
    }
    
    /**
     * Go back to the login panel.
     * @param e The action event.
     */
    @FXML
    private void Goback(ActionEvent e){
        login.Back();
    }
    
    /**
     * Get email address
     * @return String The email address.
     */
    public String getEmail()
    {
        return Email.getText();
    }
    
    /**
     * Clear the username and password textfield.
     */
    public void Clear() {
        username.setText(null);
        Email.setText(null);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
}
