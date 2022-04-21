module MiniGame {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;

	opens application to javafx.graphics, javafx.fxml;
	opens application.page.login to javafx.graphics, javafx.fxml;
	opens application.page.register to javafx.graphics, javafx.fxml;
	opens application.page.writeNotice to javafx.graphics, javafx.fxml;
}
