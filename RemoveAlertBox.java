package finalPartII;
//Katie Olson: Final Project - remove alert for GUI
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class RemoveAlertBox
{
	static boolean answer; 
	
	public static boolean display(String title, String message) 
	{
		Stage removalStage = new Stage();
		removalStage.initModality(Modality.APPLICATION_MODAL);
		removalStage.setTitle(title);
		removalStage.setMinWidth(200);
		Label label = new Label(message);
		Button yes = new Button("Yes"); 
		Button no = new Button("No"); 
		HBox hbox = new HBox(20, yes, no);
		VBox vbox = new VBox(20, label, hbox); 
		yes.setOnAction( e-> {
			answer = true;
			removalStage.close();
			
		});
		no.setOnAction( e-> {
			answer = false;
			removalStage.close();
			
		});
		vbox.setAlignment(Pos.CENTER); 
		Scene scene = new Scene(vbox); 
		removalStage.setScene(scene);
		removalStage.showAndWait();
		
		return answer;
	}

}
