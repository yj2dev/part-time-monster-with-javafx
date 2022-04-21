package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("asset/font/NanumGothic.ttf"), 10);
//		Font.loadFont(getClass().getResourceAsStream("asset/font/NanumGothicBold.ttf"), 10);

		Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("asset/img/logo.png")));
		primaryStage.setTitle("알바 몬스터");
		primaryStage.setResizable(false);
//			primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}