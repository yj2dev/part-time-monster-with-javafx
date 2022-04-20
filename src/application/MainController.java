package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private Stage stage;
    private boolean isLogin = false;

    @FXML private Button btnLogin;
    @FXML private Pane pLoginModal;
    @FXML private Pane pMainPage;
    @FXML private ScrollPane spContents;

    void changeScene(ActionEvent e, String url, String title) throws IOException{
        Node node = (Node)(e.getSource());
        stage = (Stage)(node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void onClickLogin(ActionEvent e) throws IOException {
        changeScene(e, "page/login/LoginUI.fxml", "로그인");
    }


    @FXML void onClickRegister(ActionEvent e) throws IOException {
        changeScene(e, "page/register/RegisterUI.fxml", "회원가입");
    }

    @FXML void onCloseLoginModal(ActionEvent e) {
        pLoginModal.setVisible(false);

    }
    @FXML void onShowLoginModal(ActionEvent e) {
        if (pLoginModal.isVisible()) pLoginModal.setVisible(false);
        else pLoginModal.setVisible(true);
    }

}
