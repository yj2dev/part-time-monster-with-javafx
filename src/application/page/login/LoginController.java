package application.page.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage stage;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField tfId;

    @FXML
    private PasswordField tfPassword;

    @FXML
    void onCloseLogin(ActionEvent e)throws IOException {
        Node node = (Node)(e.getSource());
        stage = (Stage)(node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/application/MainUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("알바 몬스터");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSubmitRegister(ActionEvent event) {

    }

}
