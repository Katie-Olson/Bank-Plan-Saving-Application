package finalPartII;
//Katie Olson: Final Project - this is the class for mainly part II
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class PartIITestandSerializeTypes implements Serializable
{
	public static void main(String [] args)
	{
	//Make the arraylist of security types: 
	ArrayList<SecurityTypes> secure = new ArrayList<SecurityTypes>();
	
	//Make and add 8 security types for this arrayList
	Stock stock1 = new Stock(); 
	stock1.setCurrentPrice(140);
	stock1.setNumberOfShares(20);
	stock1.setName("Pansy's Stock");
	stock1.setPurchasePricePerShare(40);
	stock1.setAbreviatedName("PASK");
	secure.add(stock1);
	
	//Second Security type
	CD cd1 = new CD(); 
	cd1.setAbreviatedName("JACD");
	cd1.setName("Jack's CD");
	cd1.setNumberOfShares(50);
	secure.add(cd1); 
	
	//Third Security type
	DividendStock dStock1 = new DividendStock();
	dStock1.setName("Harry's Dividend Stock");
	dStock1.setAbreviatedName("HADS"); 
	dStock1.setNumberOfShares(40);
	dStock1.setPurchasePricePerShare(4);
	dStock1.setCurrentPrice(5);
	dStock1.setDividendAmountPerShare(2.50); 
	secure.add(dStock1); 
	
	//Fourth Security Type
	MutualFund mF1 = new MutualFund();
	mF1.setName("Miley's Mutual Fund"); 
	mF1.setAbreviatedName("MIMF");
	mF1.setNumberOfShares(5.5);
	mF1.setPurchasePricePerShare(10); 
	secure.add(mF1);
	
	//Fifth Security Type
	Stock stock2 = new Stock(); 
	stock2.setCurrentPrice(70);
	stock2.setNumberOfShares(35);
	stock2.setName("Malcolm's Stock");
	stock2.setPurchasePricePerShare(80);
	stock2.setAbreviatedName("MASK");
	secure.add(stock2);
		
		
	//Sixth Security Type
	CD cd2 = new CD(); 
	cd2.setAbreviatedName("JECD");
	cd2.setName("Jessie's CD");
	cd2.setNumberOfShares(40);
	secure.add(cd2); 
		
		
	//Seventh Security Type
	DividendStock dStock2 = new DividendStock();
	dStock2.setName("Luna's Dividend Stock");
	dStock2.setAbreviatedName("LUDS"); 
	dStock2.setNumberOfShares(20);
	dStock2.setPurchasePricePerShare(5);
	dStock2.setCurrentPrice(6);
	dStock2.setDividendAmountPerShare(1.50); 
	secure.add(dStock2); 
		
		
	//Eighth Security Type
	MutualFund mF2 = new MutualFund();
	mF2.setName("Ron's Mutual Fund"); 
	mF2.setAbreviatedName("ROMF");
	mF2.setNumberOfShares(3.5);
	mF2.setPurchasePricePerShare(20); 
	secure.add(mF2);
	System.out.println(secure.toString());
	System.out.println("----------");
	//Probably based on the numbers, you can see that I have no knowledge on these
	//Now serialize the ArrayList
	try
	{
		FileOutputStream fos = new FileOutputStream("C:\\output\\secureList.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(secure);
		oos.close(); 
		fos.close();
	}
	
	catch(IOException exceptIO)
	{
		exceptIO.printStackTrace();
	}
	
	//Now to deserialize and put it all out there... 
	ArrayList<SecurityTypes> secureDeserialized = new ArrayList<SecurityTypes>();
    try(FileInputStream in = new FileInputStream("C:\\output\\secureList.txt");
    ObjectInputStream ois = new ObjectInputStream(in)) 
    {
    	secureDeserialized = (ArrayList<SecurityTypes>) ois.readObject();
    } 
    catch (IOException | ClassNotFoundException exceptIO) 
    {
         exceptIO.printStackTrace();
         System.out.println("Using an empty arraylist instead:");
    }
    System.out.println(secureDeserialized);
	
	
	
	
	//Now that it works after testing it, 
	//(and realizing after hours of debugging I forgot 'serializable' in the main class)
	//Here is the sorting of this arraylist through type and then name!
	//And it's bubble sort
		for(int i = 0; i < secureDeserialized.size(); i++)
		{ 
			for(int j = 0; j < (secureDeserialized.size() - 1); j++)
			{
				if(secureDeserialized.get(j).toString().compareToIgnoreCase(secureDeserialized.get(j + 1).toString()) > 0)
				{
					SecurityTypes holder = secureDeserialized.get(j);
					secureDeserialized.remove(j);
					secureDeserialized.add((j + 1), holder);
				}
			}
		}
		System.out.println(secureDeserialized.toString());
		
		//Now serialize it again to make sure I can get a saved copy for part III
		try
		{
			FileOutputStream fos = new FileOutputStream("C:\\output\\secureList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(secureDeserialized);
			oos.close(); 
			fos.close();
		}
		
		catch(IOException exceptIO)
		{
			exceptIO.printStackTrace();
		}
	
	
	
	
}}
