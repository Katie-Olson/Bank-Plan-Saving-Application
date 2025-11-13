package finalPartII;
//Katie Olson: Final Project - edit fields for GUI
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditField 
{
	static boolean verify; 
	static TextField edit;
	static String editedItem;
	
	public static String display(String title, String message, String originalitem, Button used, boolean isMutualFund) 
	{
		//Make editing stage.
		Stage editStage = new Stage();
		editStage.setMinWidth(200);
		editStage.initModality(Modality.APPLICATION_MODAL);
		editStage.setTitle(title);
		editStage.setMinWidth(200);
		Label label = new Label(message);
		TextField edit = new TextField();
		Button apply = new Button("Apply");  
		VBox vbox = new VBox(20, label, edit, apply);
		//Set button on action
		apply.setOnAction(e -> {
			editedItem = edit.getText();
			
			if(used.getText().compareTo("Edit Abreviated") == 0)
			{
				if(editedItem.length() > 4)
				{
					editedItem = originalitem; 
					InvalidEntryAlert.display();
				}
				else 
				{
					int counter = 0; 
					for(int i = 0; i < editedItem.length(); i++)
					{
						if(Character.isLetter(editedItem.charAt(i)) && Character.isUpperCase(editedItem.charAt(i))) 
						{
							counter++;
						}
					}
					if(counter < editedItem.length())
					{
						editedItem = originalitem;
						InvalidEntryAlert.display();
					}
				}
			}
			
			if((used.getText().compareTo("Edit Number") == 0 && isMutualFund == true) || 
				used.getText().compareTo("Edit Dividend Share") == 0)
			{
				try
				{
				  double catcher = Double.parseDouble(editedItem);
				  if(catcher < 0)
				  {
					  editedItem = originalitem;
						InvalidEntryAlert.display();
				  }
				}
				catch(Exception nfe)
				{
					editedItem = originalitem;
					InvalidEntryAlert.display();
				}
			}
			
			else if(used.getText().compareTo("Edit Number") == 0 || used.getText().compareTo("Edit Price") == 0
			|| used.getText().compareTo("Edit Current Price") == 0)
			{
				try
				{
				  int catcher = Integer.parseInt(editedItem);
				  if(catcher < 0)
				  {
					  editedItem = originalitem;
						InvalidEntryAlert.display();
				  }
				}
				catch(Exception nfe)
				{
					editedItem = originalitem;
					InvalidEntryAlert.display();
				}
			}
			editStage.close();
		});
		
		//Now in case enter was hit instead.
		edit.setOnAction(e -> {
			editedItem = edit.getText();
			
			if(used.getText().compareTo("Edit Abreviated") == 0)
			{
				if(editedItem.length() > 4)
				{
					editedItem = originalitem; 
					InvalidEntryAlert.display();
					
				}
				else 
				{
					int counter = 0; 
					for(int i = 0; i < editedItem.length(); i++)
					{
						if(Character.isLetter(editedItem.charAt(i)) && Character.isUpperCase(editedItem.charAt(i))) 
						{
							counter++;
						}
					}
					if(counter < editedItem.length())
					{
						editedItem = originalitem;
						InvalidEntryAlert.display();
					}
				}
			}
			
			if((used.getText().compareTo("Edit Number") == 0 && isMutualFund == true) || 
				used.getText().compareTo("Edit Dividend Share") == 0)
			{
				try
				{
				  Double.parseDouble(editedItem);
				}
				catch(NumberFormatException nfe)
				{
					editedItem = originalitem;
					InvalidEntryAlert.display();
				}
			}
			
			if(used.getText().compareTo("Edit Number") == 0 || used.getText().compareTo("Edit Price") == 0
			|| used.getText().compareTo("Edit Current Price") == 0)
			{
				try
				{
				  Integer.parseInt(editedItem);
				}
				catch(NumberFormatException nfe)
				{
					editedItem = originalitem;
					InvalidEntryAlert.display();
				}
			}
			editStage.close();
		});
		
		
		//Setting alignment
		vbox.setAlignment(Pos.CENTER); 
		Scene scene = new Scene(vbox); 
		editStage.setScene(scene);
		editStage.showAndWait();
		
		return editedItem;
	}
}
