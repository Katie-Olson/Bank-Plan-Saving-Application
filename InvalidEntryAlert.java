package finalPartII;
//Katie Olson: Final Project - invalid entry for GUI
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class InvalidEntryAlert {

	public static void display() 
	{
		Stage removalStage = new Stage();
		removalStage.initModality(Modality.APPLICATION_MODAL);
		removalStage.setTitle("Invalid Input");
		removalStage.setMinWidth(200);
		Label label = new Label("Your input was not valid. Hit the edit button to retry.");
		Button ok = new Button("Ok");
		VBox vbox = new VBox(20, label, ok); 
		ok.setOnAction(e -> removalStage.close());
		vbox.setAlignment(Pos.CENTER); 
		Scene scene = new Scene(vbox); 
		removalStage.setScene(scene);
		removalStage.showAndWait();
		
	}
}
