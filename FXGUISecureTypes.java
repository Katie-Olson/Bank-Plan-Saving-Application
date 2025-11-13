package finalPartII;
//Katie Olson: Final Project - this is the long main GUI
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

public class FXGUISecureTypes extends Application
{
	//Make some of the variables 
	Button next;
	Button previous;
	static Button editName;
	static Button editAbreviatedName;
	static Button editNumberOfShares;
	static Button editPricePerShare;
	static Button editClassName;
	static Button editCurrentPrice;
	static Button editDividendShare;
	static Label name; 
	static Label abreviatedName; 
	static Label numberOfShares; 
	static Label pricePerShare;
	static Label className;
	static Label currentPrice;
	static Label dividendShare;
	static TextField editInfo;
	static Button confirm;
	Button enter;
	static ArrayList<SecurityTypes> securityArrayList;
	static int i = 0;
	
	//Starts program
	public static void main(String[] args)
	{
		launch(args);
	}
		
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//Here is the front page of the security types.
		primaryStage.setTitle("My Secure Stocks");
		Label welcome = new Label("Welcome!");
		welcome.setFont(new Font("Arial", 24));
		Label securityIntro = new Label("Click 'enter' to check your stocks");
		enter = new Button("Enter"); 
		String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 10;\n";
		VBox layout1 = new VBox(20);
		layout1.setStyle(cssLayout);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(welcome, securityIntro, enter);
		Scene scene1 = new Scene(layout1, 400, 200);
		
		//Get serialized arrayLists from part II
		//Note: I checked, it worked, that'll save me time yesssss
		securityArrayList = new ArrayList<SecurityTypes>();
	    try(FileInputStream in = new FileInputStream("C:\\output\\secureList.txt");
	    ObjectInputStream ois = new ObjectInputStream(in)) 
	    {
	    	securityArrayList = (ArrayList<SecurityTypes>) ois.readObject();
	    } 
	    catch (IOException | ClassNotFoundException exceptIO) 
	    {
	         exceptIO.printStackTrace();
	         System.out.println("Using an empty arraylist instead:");
	    }
	     System.out.println(securityArrayList.toString());
	   
	   //Set button labels
	   
	   editName = new Button("Edit Name");
	   editAbreviatedName = new Button("Edit Abreviated"); 
	   editNumberOfShares = new Button("Edit Number");
	   editPricePerShare = new Button("Edit Price");
	   editClassName = new Button("Editing not available");
	   editCurrentPrice = new Button("Edit Current Price");
	   editDividendShare = new Button("Edit Dividend Share");
	   
	   //Set up the scene
	   Label first = new Label("This is the first stock"); 
	   Label last = new Label("This is the last stock"); 
	   Button add = new Button("Add");
	   Button remove = new Button("Remove"); 
	   Button save = new Button("Save");
	   next = new Button("Next");
	   HBox top = new HBox(200);
	   top.getChildren().addAll(first, next);
	   HBox bottom = new HBox(30, add, save, remove);
	   VBox middle = setUpAVBox(i);
	   VBox layout2 = new VBox(40, top, middle, bottom);
	   String cssLayout1 = "-fx-border-color: red;\n" +
			   "-fx-border-insets: 2;\n" +
			   "-fx-border-width: 10;\n";
	   layout2.setStyle(cssLayout1);
	   Scene scene2 = new Scene(layout2, 500, 520); 
	   enter.setOnAction(e -> primaryStage.setScene(scene2));
		
	   //Now that that works, set next on action
	   previous = new Button("Previous"); 
	   next.setOnAction(e -> {
		   i++;
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
	   });
	   
	   //Now set previous to do the opposite
	   previous.setOnAction(e -> {
		   i--;
		   if(i > 0)
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
	   });
			   
	   
	    //Prepare the remove method: 
	   remove.setOnAction(e -> {
		   if(securityArrayList.size() == 1)
		   {
			   //DO NOT REMOVE
		   }
		   else
		   {
		  boolean answer = RemoveAlertBox.display("Confirm Removing Stock", 
		  "Are you sure you want to remove this stock?");
		  if(answer == true)
		  {
			  securityArrayList.remove(i);
			  if(i > 0)
			  {
				  i--;  
			  }
			  else
			  {
				  //do nothing
			  }
			  HBox top3;
			  if(i > 0 && i < (securityArrayList.size() - 1))
			  {
				  top3 = new HBox(200, previous, next); 
			  }
			  else if(i == 0)
			  {
				  top3 = new HBox(200, first, next);   
			  }
			  else
			  {
				  top3 = new HBox(200, previous, last);
			  }
			   VBox middle3 = setUpAVBox(i);
			   VBox layout4 = new VBox(40, top3, middle3, bottom); 
			   Scene scene4 = new Scene(layout4, 500, 520);
			   primaryStage.setScene(scene4);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout4.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout4.setStyle(cssLayout2);  
			   }
		  }
		   }
	   });
	   
	   
	   //Now set a method for the save method
	   save.setOnAction(e -> 
	   {
		   boolean answer = RemoveAlertBox.display("Confirm Save File", 
		   "Would you like to save your progress?");
		   if(answer == true)
		   {
			   try
				{
					FileOutputStream fos = new FileOutputStream("C:\\output\\secureList.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(securityArrayList);
					oos.close(); 
					fos.close();
					SaveConfirmed.display("Save confirmed", "Your current stocks have been saved");
				}
				
				catch(IOException exceptIO)
				{
					exceptIO.printStackTrace();
				}
		   }
	   
	   });
	    
	   
	   //Now try edits setting on action: 
	   //Edit name
	   editName.setOnAction(e -> 
	   {
		   String newName = EditField.display("Editing Name", "What should the name of this be?", 
		   securityArrayList.get(i).getName(), editName, false); 
		   securityArrayList.get(i).setName(newName); 
		   name = new Label("Name: " + newName); 
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }}
		   
	   });
	   
	   
	   
	   //Now repeat for the other edits... 
	   editAbreviatedName.setOnAction(e -> 
	   {
		   String newName = EditField.display("Editing Abreviated Name", "What should the abreviated name of this be?", 
		   securityArrayList.get(i).getAbreviatedName(), editAbreviatedName, false); 
		   securityArrayList.get(i).setAbreviatedName(newName); 
		   abreviatedName = new Label("Abreviated Name: " + newName); 
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }}
		   
	   });
	   
	   
	   //Now number of shares
	   editNumberOfShares.setOnAction(e -> 
	   {
		   boolean isMf = false;
		   if(securityArrayList.get(i).toString().charAt(0) == 'M')
		   {
			   isMf = true;
			   MutualFund m = (MutualFund) securityArrayList.get(i);
			   String use =("" + m.getNumberOfSharesFractional());
			   String newName = EditField.display("Editing Number of Shares", "How many shares are there?", 
			   use, editNumberOfShares, isMf); 
			   m.setNumberOfShares(Double.parseDouble(newName));
			   securityArrayList.set(i, m);
			   numberOfShares = new Label("Number of Shares: " + newName); 
			   
		   }
		   else
		   {
			  String use = "" + securityArrayList.get(i).getNumberOfShares();
			  String newName = EditField.display("Editing Number of Shares", "How many shares are there?", 
			  use, editNumberOfShares, isMf); 
			  securityArrayList.get(i).setNumberOfShares(Integer.parseInt(newName));
			  numberOfShares = new Label("Number of Shares: " + newName); 
			  
		   }
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }}
		   
	   });
	
		//Now for purchase price per share
	   editPricePerShare.setOnAction(e -> 
	   {
		   if(securityArrayList.get(i).toString().charAt(0) == 'C')
		   {
			   //Don't do a single thing :)
		   }
		   else
		   {
			   String use = ("" + securityArrayList.get(i).getPurchasePricePerShare());
			   String newName = EditField.display("Editing Price Per Share", "What should the purchase price be? "
			   		+ "(Please set to integer)", use, editPricePerShare, false); 
			   securityArrayList.get(i).setPurchasePricePerShare(Integer.parseInt(newName)); 
			   pricePerShare = new Label("Purchase price per share: " + newName); 
		   }
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }}
		   
	   });
	   
	   //Now Current Price
	   editCurrentPrice.setOnAction(e -> 
	   {
		   Stock usable; 
		   DividendStock usable2;
		   if(securityArrayList.get(i).toString().charAt(0) == 'S')
		   {
			   usable = (Stock) securityArrayList.get(i);
			   String useableAgain = "" + usable.getCurrentPrice();
			   String newName = EditField.display("Editing Current Price", "What should the current price be? "
			   + "(please set to integer)", useableAgain, editCurrentPrice, false); 
			   usable.setCurrentPrice(Integer.parseInt(newName));
			   securityArrayList.set(i, usable);
			   currentPrice = new Label("Current Price: " + newName);
		   }
		   if(securityArrayList.get(i).toString().charAt(0) == 'D')
		   {
			   usable2 = (DividendStock) securityArrayList.get(i);
			   String useableAgain = "" + usable2.getCurrentPrice();
			   String newName = EditField.display("Editing Current Price", "What should the current price be? "
			   + "(please set to integer)", useableAgain, editCurrentPrice, false); 
			   usable2.setCurrentPrice(Integer.parseInt(newName));
			   securityArrayList.set(i, usable2);
			   currentPrice = new Label("Current Price: " + newName);
		   }
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }}
		   
	   });
	   
	   
	   //Lastly Dividend share
	   editDividendShare.setOnAction(e -> 
	   {
		   DividendStock use = (DividendStock) securityArrayList.get(i); 
		   String usable = "" + use.getDividendAmountPerShare();
		   String newName = EditField.display("Editing Dividend Amount", 
		   "What should the dividend amount per share of this be?", usable, editDividendShare, false); 
		   use.setDividendAmountPerShare(Double.parseDouble(newName));
		   securityArrayList.set(i, use);
		   dividendShare = new Label("Dividend amount per share: " + newName); 
		   if(i < (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n";
				   layout3.setStyle(cssLayout2);  
			   }
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
		   }
		   if(i == (securityArrayList.size() - 1))
		   {
			   HBox top2 = new HBox(200, previous, last); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }
		   }
		   if(i == 0)
		   {
			   HBox top2 = new HBox(200, first, next); 
			   VBox middle2 = setUpAVBox(i);
			   VBox layout3 = new VBox(40, top2, middle2, bottom); 
			   Scene scene3 = new Scene(layout3, 500, 520);
			   primaryStage.setScene(scene3);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout3.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout3.setStyle(cssLayout2);  
			   }}
		   
	   });
	   
	   
	   
	   
	   
	   //Here is the add method for the grand finale! 
	   add.setOnAction( e  -> 
	   {
		   String choose = AddClass.display();
		  
		   //In case of closure
		   if(choose == null)
		   {
			  choose = "Nada" ;
		   }
		   
		   
		   if(choose.compareToIgnoreCase("CD") == 0)
		   {
			   CD newcd = new CD(); 
			   String newName = EditField.display("Adding Name", "What should the name of this be?", 
			   "Default CD", editName, false); 
			   String newAbreviatedName = EditField.display("Adding Abreviated Name",
			   "What should the abreviated name of this be?", "DECD" , editAbreviatedName, false); 
			   String newNumberOfShares = EditField.display("Editing Number of Shares", "How many shares are there?", 
			   "0", editNumberOfShares, false); 
			   newcd.setName(newName);
			   newcd.setAbreviatedName(newAbreviatedName); 
			   newcd.setNumberOfShares(Integer.parseInt(newNumberOfShares));
			   for(int i = 0; i < securityArrayList.size(); i++)
			   {
				   if(newcd.toString().compareTo(securityArrayList.get(i).toString()) <= 0)
				   {
					   securityArrayList.add(i, newcd);
					   i = securityArrayList.size();
					 
				   }
			   }
			   
		   }
		   
		   if(choose.compareToIgnoreCase("Dividend Stock") == 0)
		   {
			   DividendStock newdivs = new DividendStock(); 
			   String newName = EditField.display("Adding Name", "What should the name of this be?", 
			   "Default Dividend Stock", editName, false); 
			   String newAbreviatedName = EditField.display("Adding Abreviated Name",
			   "What should the abreviated name of this be?", "DEDS" , editAbreviatedName, false); 
			   String newNumberOfShares = EditField.display("Editing Number of Shares", "How many shares are there?", 
			   "0", editNumberOfShares, false); 
			   String newPPS = EditField.display("Editing Price Per Share", "What should the purchase price be? "
			   + "(Please set to integer)","20" , editPricePerShare, false);
			   String newCP = EditField.display("Editing Current Price", "What should the current price be? "
			   + "(please set to integer)", "10", editCurrentPrice, false); 
			   String newDVA = EditField.display("Editing Dividend Amount", 
			   "What should the dividend amount per share of this be?", "2.5", editDividendShare, false);
			   newdivs.setName(newName);
			   newdivs.setAbreviatedName(newAbreviatedName); 
			   newdivs.setNumberOfShares(Integer.parseInt(newNumberOfShares));
			   newdivs.setPurchasePricePerShare(Integer.parseInt(newPPS));
			   newdivs.setCurrentPrice(Integer.parseInt(newCP)); 
			   newdivs.setDividendAmountPerShare(Double.parseDouble(newDVA));
			   for(int i = 0; i < securityArrayList.size(); i++)
			   {
				   if(newdivs.toString().compareTo(securityArrayList.get(i).toString()) <= 0)
				   {
					   securityArrayList.add(i, newdivs);
					   i = securityArrayList.size();
				   }
			   }
			   
		   }
		   
		   if(choose.compareToIgnoreCase("Mutual Fund") == 0)
		   {
			   MutualFund newMF = new MutualFund(); 
			   String newName = EditField.display("Adding Name", "What should the name of this be?", 
			   "Default Mutual Fund", editName, false); 
			   String newAbreviatedName = EditField.display("Adding Abreviated Name",
			   "What should the abreviated name of this be?", "DEMF" , editAbreviatedName, false); 
			   String newNumberOfShares = EditField.display("Editing Number of Shares", "How many shares are there?", 
			   "0", editNumberOfShares, true); 
			   String newPPS = EditField.display("Editing Price Per Share", "What should the purchase price be? "
			   + "(Please set to integer)","20" , editPricePerShare, false);
			   newMF.setName(newName);
			   newMF.setAbreviatedName(newAbreviatedName); 
			   newMF.setNumberOfShares(Double.parseDouble(newNumberOfShares));
			   newMF.setPurchasePricePerShare(Integer.parseInt(newPPS));
			   for(int i = 0; i < securityArrayList.size(); i++)
			   {
				   if(newMF.toString().compareTo(securityArrayList.get(i).toString()) <= 0)
				   {
					   securityArrayList.add(i, newMF);
					   i = securityArrayList.size();
				   }
			   }
			   
		   }
		   
		   if(choose.compareToIgnoreCase("Stock") == 0)
		   {
			   Stock newst = new Stock(); 
			   String newName = EditField.display("Adding Name", "What should the name of this be?", 
			   "Default Stock", editName, false); 
			   String newAbreviatedName = EditField.display("Adding Abreviated Name",
			   "What should the abreviated name of this be?", "DEST" , editAbreviatedName, false); 
			   String newNumberOfShares = EditField.display("Editing Number of Shares", "How many shares are there?", 
			   "0", editNumberOfShares, false); 
			   String newPPS = EditField.display("Editing Price Per Share", "What should the purchase price be? "
			   + "(Please set to integer)","20" , editPricePerShare, false);
			   String newCP = EditField.display("Editing Current Price", "What should the current price be? "
			   + "(please set to integer)", "10", editCurrentPrice, false);
			   newst.setName(newName);
			   newst.setAbreviatedName(newAbreviatedName); 
			   newst.setNumberOfShares(Integer.parseInt(newNumberOfShares));
			   newst.setPurchasePricePerShare(Integer.parseInt(newPPS));
			   newst.setCurrentPrice(Integer.parseInt(newCP)); 
			   for(int i = 0; i < securityArrayList.size(); i++)
			   {
				   if(newst.toString().compareTo(securityArrayList.get(i).toString()) <= 0)
				   {
					   securityArrayList.add(i, newst);
					   i = securityArrayList.size();
				   }
			   }
			   
		   }
		   
		   
		   HBox top3;
			  if(i > 0 && i < (securityArrayList.size() - 1))
			  {
				  top3 = new HBox(200, previous, next); 
			  }
			  else if(i == 0)
			  {
				  top3 = new HBox(200, first, next);   
			  }
			  else
			  {
				  top3 = new HBox(200, previous, last);
			  }
			   VBox middle3 = setUpAVBox(i);
			   VBox layout4 = new VBox(40, top3, middle3, bottom); 
			   Scene scene4 = new Scene(layout4, 500, 520);
			   primaryStage.setScene(scene4);
			   if(i % 2 == 0)
			   {
				   String cssLayout2 = "-fx-border-color: red;\n" +
						   "-fx-border-insets: 2;\n" +
						   "-fx-border-width: 10;\n" + 
						   "-fx-text-fill: green;\n";
				   layout4.setStyle(cssLayout2);
			   }
			   else
			   {
				   String cssLayout2 = "-fx-border-color: green;\n" +
			                "-fx-border-insets: 2;\n" +
			                "-fx-border-width: 10;\n" + 
			                "-fx-text-fill: red;\n";
				   layout4.setStyle(cssLayout2);  
			   }
		  
	   });
	   
	   //Also in case of main stage closure
	   primaryStage.setOnCloseRequest(e-> {
		   boolean answer = RemoveAlertBox.display("Confirm Save File", 
				   "Would you like to save your progress before exiting?");
				   if(answer == true)
				   {
					   try
						{
							FileOutputStream fos = new FileOutputStream("C:\\output\\secureList.txt");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(securityArrayList);
							oos.close(); 
							fos.close();
							SaveConfirmed.display("Save confirmed", "Your current stocks have been saved");
						}
						
						catch(IOException exceptIO)
						{
							exceptIO.printStackTrace();
						}
				   }
			   primaryStage.close();
		   
	   });
		
		//Here is to setting the first scene.
		primaryStage.setScene(scene1);
		primaryStage.show();
		
	}
	
	public static VBox setUpAVBox(int i)
	{
		//make a new VBox 
		VBox securitySetup = new VBox(40);
		
		//Name label's
	    name = new Label("Name: " + securityArrayList.get(i).getName());
	    
	    //AbreviatedName
	    abreviatedName = new Label("Abreviated Name: " + 
	    securityArrayList.get(i).getAbreviatedName());
	    
	    //Number of shares
	    numberOfShares = new Label("Number of Shares: " + 
	    securityArrayList.get(i).getNumberOfShares());
	    
	    //Price per share
	    pricePerShare = new Label("Purchase price per share: " +
	    securityArrayList.get(i).getPurchasePricePerShare());
	    
	    //Now see which ones need additional labels/buttons
	    if(securityArrayList.get(i).toString().charAt(0) == 'C')
	    {
	    	CD cdCurrent = (CD) securityArrayList.get(i);
	    	className = new Label("Type: CD");
	    	VBox vb1 = new VBox(40, name, abreviatedName, numberOfShares, pricePerShare); 
	    	VBox vb2 = new VBox(30, editName, editAbreviatedName, editNumberOfShares, 
	    	editPricePerShare); 
	    	HBox hb1 = new HBox(100, vb1, vb2); 
	    	securitySetup.getChildren().addAll(className, hb1);
	    	
	    }
	    else if(securityArrayList.get(i).toString().charAt(0) == 'D')
	    {
	    	DividendStock dividendCurrent = (DividendStock) 
	    	securityArrayList.get(i);
	    	className = new Label("Type: Dividend Stock");
	    	dividendShare = new Label("Dividend amount per share: " + 
	    	dividendCurrent.getDividendAmountPerShare());
	    	currentPrice = new Label("Current Price per Share: "
	    	+ dividendCurrent.getCurrentPrice());
	    	VBox vb1 = new VBox(40, name, abreviatedName, numberOfShares, pricePerShare, 
	    	currentPrice, dividendShare); 
	    	VBox vb2 = new VBox(30, editName, editAbreviatedName, editNumberOfShares, 
	    	editPricePerShare, editCurrentPrice, editDividendShare); 
	    	HBox hb1 = new HBox(100, vb1, vb2); 
	    	securitySetup.getChildren().addAll(className, hb1);
	    }
	    else if(securityArrayList.get(i).toString().charAt(0) == 'M')
	    {
	    	MutualFund mutualCurrent = (MutualFund) securityArrayList.get(i);
	    	className = new Label("Type: Mutual Fund");
	    	numberOfShares = new Label("Number of shares: " +
	    	mutualCurrent.getNumberOfSharesFractional());
	    	VBox vb1 = new VBox(40, name, abreviatedName, numberOfShares, pricePerShare); 
	    	VBox vb2 = new VBox(30, editName, editAbreviatedName, editNumberOfShares, 
	    	editPricePerShare); 
	    	HBox hb1 = new HBox(100, vb1, vb2); 
	    	securitySetup.getChildren().addAll(className, hb1);
	    }
	    else
	    {
	    	Stock stockCurrent = (Stock) securityArrayList.get(i);
	    	className = new Label("Type: Stock");
	    	currentPrice = new Label("Current Price per Share: "
	    	+ stockCurrent.getCurrentPrice());
	    	VBox vb1 = new VBox(40, name, abreviatedName, numberOfShares, pricePerShare, 
	    	currentPrice); 
	    	VBox vb2 = new VBox(30, editName, editAbreviatedName, editNumberOfShares, 
	    	editPricePerShare, editCurrentPrice); 
	    	HBox hb1 = new HBox(100, vb1, vb2); 
	    	securitySetup.getChildren().addAll(className, hb1);
	    	
	    }
	    return securitySetup;
	}

}
