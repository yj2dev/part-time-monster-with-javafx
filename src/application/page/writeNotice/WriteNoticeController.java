package application.page.writeNotice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class WriteNoticeController {
    private Stage stage;

    @FXML
    private Button btnRegister;

    @FXML
    private Pane pHeader;

    @FXML
    private RadioButton rbMan1;

    @FXML
    private RadioButton rbMan2;

    @FXML
    private RadioButton rbWoman1;

    @FXML
    private RadioButton rbWoman2;

    @FXML
    private ToggleGroup selectSexGroup1;

    @FXML
    private ToggleGroup selectSexGroup2;

    @FXML
    private Text tUserType;

    @FXML
    private TextField tfBirth1;

    @FXML
    private TextField tfBirth2;

    @FXML
    private TextField tfEmail1;

    @FXML
    private TextField tfEmail2;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfId1;

    @FXML
    private TextField tfName1;

    @FXML
    private TextField tfName2;

    @FXML
    private TextField tfPhone1;

    @FXML
    private TextField tfPhone2;

    @FXML
    void onClickBack(ActionEvent e) throws IOException {
        Node node = (Node)(e.getSource());
        stage = (Stage)(node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/application/MainUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("알바 몬스터");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSubmitWriteNotice(ActionEvent e) {

    }

}
