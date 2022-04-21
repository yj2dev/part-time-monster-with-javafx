package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage stage;
    private boolean isLogin = false;

    @FXML private Button btnLogin;
    @FXML private Pane pLoginModal;
    @FXML private Pane pMainPage;
    @FXML private ScrollPane spContents;

    @FXML private Label lbUsername;

    private List<Pane> partTimeList = new ArrayList<Pane>();



    private VBox vbItems = new VBox(5);

    @FXML void connectButton(ActionEvent e) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = "SELECT * FROM 고객";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            System.out.println("queryOutput >> " + queryOutput);

            while(queryOutput.next()){
                lbUsername.setText(queryOutput.getString("고객이름"));
            }
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML void onClickSearch(ActionEvent e) throws IOException {
//        changeScene(e, "page/writeNotice/WriteNoticeUI.fxml", "채용공고 작성");
        System.out.println("검색");
    }

    @FXML void onClickWriteNotice(ActionEvent e) throws IOException {
        changeScene(e, "page/writeNotice/WriteNoticeUI.fxml", "채용공고 작성");
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
    void changeScene(ActionEvent e, String url, String title) throws IOException{
        Node node = (Node)(e.getSource());
        stage = (Stage)(node.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Label lCompany = new Label("호남대 주차팀");
        Label lTitle = new Label("호남대 발랫파킹 요원구합니다.");
        Text tSalay = new Text("시급 19,000원");
        Text tAddress = new Text("광주광역시");

        lCompany.setStyle("-fx-text-fill: #ffffff");
        lTitle.setStyle("-fx-text-fill: #ffffff");
        Pane pDummy = new Pane(lTitle);

        lCompany.setPadding(new Insets(20));
        pDummy.getChildren().addAll(lCompany);

        pDummy.setStyle("-fx-background-color: blue;");
        pDummy.setPadding(new Insets(12));
        pDummy.setPrefSize(0, 150);  //v: width, v1: height



        vbItems.setMargin(pDummy, new Insets(12));
        partTimeList.add(pDummy);
        spContents.setContent(vbItems);
        spContents.setFitToWidth(true);

        vbItems.getChildren().add(partTimeList.get(0));
    }
}
