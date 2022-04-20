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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;


public class LoginController {

    private boolean isCompanyLogin = false;
    @FXML private Button btnCompany;
    @FXML private Button btnLogin;
    @FXML private Button btnPrivate;
    @FXML private TextField tfId;
    @FXML private PasswordField tfPassword;

    @FXML
    void onSubmitLogin(ActionEvent e) {
        HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("user_id", tfId.getText());
        payload.put("user_password", tfPassword.getText());

        System.out.println("payload >> " + payload);
    }

    @FXML void onClickPrivate(ActionEvent e) {
        isCompanyLogin = false;
        btnLogin.setStyle("-fx-background-color: #fde000; -fx-cursor: hand");
        btnCompany.setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #e2e2e2; -fx-cursor: hand;");
        btnPrivate.setStyle("-fx-background-color: #ffffff; -fx-border-color: #f3cd1e; -fx-border-width: 2px; -fx-cursor: hand;");
    }
    @FXML void onClickCompany(ActionEvent e) {
        isCompanyLogin = true;
        btnLogin.setStyle("-fx-background-color: #3266cc; -fx-text-fill:#ffffff; -fx-cursor: hand");
        btnPrivate.setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #e2e2e2; -fx-cursor: hand;");
        btnCompany.setStyle("-fx-background-color: #ffffff; -fx-border-color: #6a81e2; -fx-border-width: 2px; -fx-cursor: hand;");
    }

    @FXML void onClickRegisterLink(MouseEvent e) throws IOException {
        Node node = (Node)(e.getSource());
        Stage stage = (Stage) (node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/application/page/register/RegisterUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("회원가입");
        stage.setScene(scene);
        stage.show();
    }

    @FXML void onCloseLogin(ActionEvent e) throws IOException {
        Node node = (Node)(e.getSource());
        Stage stage = (Stage) (node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/application/MainUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("알바 몬스터");
        stage.setScene(scene);
        stage.show();
    }
}
