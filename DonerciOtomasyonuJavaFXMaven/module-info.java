module AidatTakipJavaFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires waffle.jna;
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
