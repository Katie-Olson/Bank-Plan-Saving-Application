package finalPartII;
//Katie Olson: Final Project - add class for GUI
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class AddClass 
{
	static String chosen;
	
	public static String display() 
	{
		Stage removalStage = new Stage();
		removalStage.initModality(Modality.APPLICATION_MODAL);
		removalStage.setTitle("Adding Security Type");
		Label label = new Label("What type of security would you like to add?");
		Button cD = new Button("CD"); 
		Button dividendStock = new Button("Dividend Stock"); 
		Button stock = new Button("Stock");
		Button mutualFund = new Button("Mutual Fund");
		GridPane pane = new GridPane();
		pane.add(cD, 1, 0);
		pane.add(dividendStock, 0, 0);
		pane.add(stock, 0, 1);
		pane.add(mutualFund, 1, 1);
		pane.setHgap(40);
		pane.setVgap(40);
		cD.setOnAction(e -> {
			chosen = "CD"; 
			removalStage.close();
		});
		dividendStock.setOnAction(e -> {
			chosen = "Dividend Stock"; 
			removalStage.close();
		});
		stock.setOnAction(e -> {
			chosen = "Stock"; 
			removalStage.close();
		});
		mutualFund.setOnAction(e -> {
			chosen = "MutualFund"; 
			removalStage.close();
		});
		VBox vbox = new VBox(20, label, pane); 
		vbox.setAlignment(Pos.CENTER); 
		Scene scene = new Scene(vbox, 300, 300); 
		removalStage.setScene(scene);
		removalStage.showAndWait();
		
		return chosen;
	}

}
