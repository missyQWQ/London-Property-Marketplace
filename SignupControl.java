import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.util.regex.*;
import java.lang.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * This is the controller of Signup.fxml.
 * 
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class SignupControl implements Initializable
{
    //text field
    @FXML private  TextField username;
    @FXML private  TextField Password;
    @FXML private  TextField Email;
    //button
    @FXML private  Button Continue;
    @FXML private  Button Back;
    //Label
    @FXML private  Label User;
    @FXML private  Label Pass;
    @FXML private  Label Mail;
    private Login login;
    private Validity validity = Validity.getInstance();

    /**
     * To set the airbnb app
     * @param login
     */
    public void setApp(Login login){
        this.login = login;
    }

    /**
     * While you creating a new account, it will check if all
     * the information you provide is valid when you click continue button.
     * @param e The action event.
     */
    @FXML
    private void Finish(ActionEvent e)
    {
        HashMap<String,String> Info = new HashMap<String,String>();
        if(username.getText().length()==0)
        {
            User.setText("Must have a username!");
            User.setTextFill(Color.RED);
            return;
        }
        else{User.setText("");}
        if(Password.getText().length()==0)
        {
            Pass.setText("Must have a password!");
            Pass.setTextFill(Color.RED);
            return;
        }
        else{Pass.setText("");}
        if(Email.getText().length()==0)
        {
            Mail.setText("Must have a email!");
            Mail.setTextFill(Color.RED);
            return;
        }
        else{Mail.setText("");}

        if(username.getText().length()<6)
        {
            User.setText("Username less than 6 words!");
            User.setTextFill(Color.RED);
            return;
        }
        else{User.setText("");}
        if(validity.CheckSame(username.getText()))
        {
            User.setText("Username has been used!");
            User.setTextFill(Color.RED);
            return;
        }
        else{User.setText("");}
        if(!If_long_short(Password.getText()))
        {
            Pass.setText("Password is too long/short!");
            Pass.setTextFill(Color.RED);
            return;
        }
        else{Pass.setText("");}
        if(!If_Has_Word(Password.getText()))
        {
            Pass.setText("Must have at least one letter!");
            Pass.setTextFill(Color.RED);
            return;
        }
        else{Pass.setText("");}
        if(!If_Capital(Password.getText()))
        {
            Pass.setText("Must have one capital letter!");
            Pass.setTextFill(Color.RED);
            return;
        }
        else{Pass.setText("");}
        if(!If_is_address(Email.getText()))
        {
            Mail.setText("The Email has to be valid!");
            Mail.setTextFill(Color.RED);
            return;
        }
        else{Pass.setText("");}
        if(validity.CheckMail(Email.getText()))
        {
            Mail.setText("Email has been used!");
            Mail.setTextFill(Color.RED);
            return;
        }
        else{Mail.setText("");}
        User.setText("Username is valid!");
        User.setTextFill(Color.GREEN);
        Pass.setText("Password is valid!");
        Pass.setTextFill(Color.GREEN);
        Mail.setText("Email is valid!");
        Mail.setTextFill(Color.GREEN);
        Info.put("username",username.getText());
        Info.put("password",Password.getText());
        Info.put("email",Email.getText());
        login.Continue(Info);

    }
    
    /**
     * Go back to the login page.
     * @param e The action event.
     */
    @FXML
    private void Goback(ActionEvent e)
    {
        login.Back();
    }

    /**
     * Check if Password is too long/short.
     * @param password
     * @return Boolean If valid, then true, or false
     * otherwise.
     */
    public boolean If_long_short(String password) {
        boolean valid = false;
        if(password.length()>=9&&password.length()<=16)
        {
            valid=true;
        }
        return valid;
    }

    /**
     * Check if Password has capital letters.
     * @param password
     * @return Boolean If there is capital letter, then true,
     * or false otherwise.
     */
    public boolean If_Capital(String password) {
        String regex=".*[A-Z]+.*";
        Matcher m=Pattern.compile(regex).matcher(password);
        return m.matches();
    }

    /**
     * Check if Password has letters.
     * @param password
     * @return Boolean If there is a letter, then true,
     * or false otherwise.
     */
    public boolean If_Has_Word(String password) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m=Pattern.compile(regex).matcher(password);
        return m.matches();
    }

    /**
     * Check if the email is vaild.
     * @param email
     * @return Boolean If it is vaild, or false otherwise
     */
    public boolean If_is_address(String email) {
        String regex="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Matcher m=Pattern.compile(regex).matcher(email);
        return m.matches();
    }

    /**
     * Get email address
     * @return String The email address.
     */
    public String getEmail()
    {
        return Email.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
