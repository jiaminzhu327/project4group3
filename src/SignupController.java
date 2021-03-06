import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SignupController {
    
    @FXML
    private TextField sign_up_firstName;
    
    @FXML
    private TextField sign_up_lastName;
    
    @FXML
    private TextField sign_up_age;
    
    @FXML
    private TextField sign_up_email;
    
    @FXML
    private TextField sign_up_username;
    
    @FXML
    private PasswordField sign_up_password;
    
    @FXML
    private PasswordField sign_up_confirmPassword;
    
    @FXML
    private Button sign_up_registerButton;
    
    @FXML
    private Button sign_up_cancelButton;

    @FXML
    private Label username_avail;

    @FXML
    private Label passwordMatches;

    @FXML
    private Label passwordDoesntMatch;

    
    @FXML
    private void registerUser (ActionEvent event) throws Exception{
        //TODO Using DAO objects pass data to DB
        //TODO Let user know if account creation was successful
        //Returns back to login after account creation
        Parent signUpPageParent = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Scene signUpPageScene = new Scene(signUpPageParent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

//        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setX((screenBounds.getWidth() - 720) / 2);
//        stage.setY((screenBounds.getHeight() - 720) / 2);

        stage.setResizable(false);
        stage.setScene(signUpPageScene);
        stage.show();
    }
    
    @FXML
    private void cancelRegistration (ActionEvent event) throws Exception{

        //TODO Prompt user if they are sure they want to cancel registration

        System.out.println("Cancel button pressed");
        Parent signUpPageParent = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Scene signUpPageScene = new Scene(signUpPageParent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - 720) / 2);
        stage.setY((screenBounds.getHeight() - 720) / 2);

        stage.setResizable(false);
        stage.setScene(signUpPageScene);
        stage.show();
    }

    @FXML
    private void matchPasswords(){
        if(sign_up_password.getText().equals("") || sign_up_confirmPassword.getText().equals("")){
            passwordMatches.setVisible(false);
            passwordDoesntMatch.setVisible(false);
            sign_up_password.setStyle("-fx-border-color: #DCDCDC;");
            sign_up_confirmPassword.setStyle("-fx-border-color: #DCDCDC;");
        }else if(sign_up_password.getText().equals(sign_up_confirmPassword.getText())) {
            passwordDoesntMatch.setVisible(false);
            passwordMatches.setVisible(true);
            sign_up_password.setStyle("-fx-border-color: #00FF3C;");
            sign_up_confirmPassword.setStyle("-fx-border-color: #00FF3C;");
        }else{
            passwordMatches.setVisible(false);
            passwordDoesntMatch.setVisible(true);
            sign_up_password.setStyle("-fx-border-color: red;");
            sign_up_confirmPassword.setStyle("-fx-border-color: red;");
        }
    }

    @FXML
    private void checkUsername(){
        // TODO Check DB if username already exits if so warn user.
        if(!sign_up_username.getText().equals("username")){ // Username is taken
            sign_up_username.setStyle("-fx-border-color: red; -fx-text-inner-color: red;");
            username_avail.setVisible(true);

        }else if(sign_up_username.getText().equals("")){
            sign_up_username.setStyle("-fx-border-color: #DCDCDC; -fx-text-inner-color: black;");
            username_avail.setVisible(false);
        }else{
            sign_up_username.setStyle("-fx-border-color: #00FF3C; -fx-text-inner-color: #00FF3C;");
            username_avail.setVisible(false);
        }
    }

}
