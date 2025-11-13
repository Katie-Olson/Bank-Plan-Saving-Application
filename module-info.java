module katieFX {
	requires javafx.controls;
	requires javafx.media; 
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens finalPartII to javafx.graphics, javafx.fxml;
}
