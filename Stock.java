package finalPartII;
//Katie Olson: Final Project - this is the Stock Class
import java.io.Serializable;

public class Stock extends SecurityTypes implements Serializable
{
	private int currentPrice; 
	
	
	//Set current price 
	protected void setCurrentPrice(int price)
	{
		if(price > 0)
		{
			currentPrice = price;
		}
	}
	
	
	//Get current price. 
	protected int getCurrentPrice() 
	{
		return currentPrice;
	}
	
	
	public String toString()
	{
		return ("Stock: " + super.toString());
	}
}