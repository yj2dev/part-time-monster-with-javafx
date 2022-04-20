package application.page.register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    private Stage stage;

    @FXML private RadioButton rbPrivate;
    @FXML private RadioButton rbCompany;
    @FXML private Pane pHeader;
    @FXML private Text tUserType;
    @FXML private ToggleGroup userTypeGroup;
    @FXML private TextField tfId;
    @FXML private TextField tfPassword;
    @FXML private TextField tfCheckPassword;
    @FXML private TextField tfName;
    @FXML private TextField tfBirth;
    @FXML private ToggleGroup selectSexGroup;
    @FXML private RadioButton rbMan;
    @FXML private RadioButton rbWoman;
    @FXML private TextField tfEmail;
    @FXML private TextField tfPhone;
    @FXML private Pane pCompanyForm;
    @FXML private TextField tfCompanyNumber;
    @FXML private TextField tfCompanyName;
    @FXML private TextField tfCompanyCeoName;
    @FXML private TextField tfCompanyContact;
    @FXML private TextField tfCompanyAddress;
    ObservableList<String> companySizeList = FXCollections.observableArrayList("스타트업","중소기업","중견기업", "대기업");
    @FXML private ChoiceBox<String> cbCompanySize;
    @FXML private Button btnRegister;


    String getSelectSex(){
        if(rbMan.isSelected()) return rbMan.getText();
        else if(rbWoman.isSelected()) return rbWoman.getText();
        else return null;
    }

    @FXML
    void onSubmitRegister(ActionEvent e) {
        HashMap<String, String> payload = new HashMap<String, String>();

        payload.put("user_id", tfId.getText());
        payload.put("user_password", tfPassword.getText());
        payload.put("user_name", tfName.getText());
        payload.put("user_birth", tfBirth.getText());
        payload.put("user_sex", getSelectSex());
        payload.put("user_email", tfEmail.getText());
        payload.put("user_phone", tfPhone.getText());

        if(rbCompany.isSelected()){
            payload.put("company_number", tfCompanyNumber.getText());
            payload.put("company_name", tfCompanyName.getText());
            payload.put("company_ceo_name", tfCompanyCeoName.getText());
            payload.put("company_contact", tfCompanyContact.getText());
            payload.put("company_address", tfCompanyAddress.getText());
            payload.put("company_size", cbCompanySize.getValue());
        }
        System.out.println("payload >> " + payload);
    }

    @FXML
    void onClickUserType(ActionEvent e) {
        if (rbPrivate.isSelected()) {
            tUserType.setText("개인회원 가입");
            tUserType.setFill(Color.BLACK);
            pHeader.setStyle("-fx-background-color: #ffeb00;");
            btnRegister.setStyle("-fx-background-color: #ffeb00; -fx-text-fill:#000000");
            pCompanyForm.setVisible(false);
        } else {
            tUserType.setText("기업회원 가입");
            tUserType.setFill(Color.WHITE);
            pHeader.setStyle("-fx-background-color: #3266cc;");
            btnRegister.setStyle("-fx-background-color: #3266cc; -fx-text-fill:#ffffff");
            pCompanyForm.setVisible(true);
        }
    }

    @FXML void onClickBack(ActionEvent e) throws IOException {
        Node node = (Node)(e.getSource());
        stage = (Stage)(node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/application/MainUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("알바 몬스터");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbCompanySize.setItems(companySizeList);
        cbCompanySize.setValue("스타트업");
        rbPrivate.setSelected(true);
    }
}
