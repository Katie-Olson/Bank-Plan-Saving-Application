package finalPartII;
//Katie Olson: Final Project - save alert for GUI
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class SaveConfirmed 
{
	public static void display(String title, String message) 
	{
		Stage save = new Stage();
		save.initModality(Modality.APPLICATION_MODAL);
		save.setTitle(title);
		save.setMinWidth(200);
		Label label = new Label(message);
		Button close = new Button("Close"); 
		VBox vbox = new VBox(20, label, close); 
		close.setOnAction(e -> save.close());
		vbox.setAlignment(Pos.CENTER); 
		Scene scene = new Scene(vbox); 
		save.setScene(scene);
		save.showAndWait();
	}

}
