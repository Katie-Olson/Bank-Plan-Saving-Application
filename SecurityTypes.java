package finalPartII;
//Katie Olson: Final Project - this is the base security Class
import java.io.Serializable;

public class SecurityTypes implements SecurityInterface, Serializable
{
	//Private variables
	private String givenName = "Please give me a name"; 
	private String abrName = "Please give me an abreviated name";
	private int pricePerShare = 0;
	private int numOfShares = 0; 
	
	
	//Set the name.
	@Override
	public void setName(String specificName)
	{
		givenName = specificName;
	}
	
	//Get the name.
	@Override
	public String getName()
	{
		return givenName;
	}
	
	public boolean verifyAbreviatedName(String aName)
	{
		//Check length requirements
				if(aName.length() > 4)
				{
					return false;
				}
					//Check if there's a special character or digit and that it's entirely capitalized
					int counter = 0;
					for(int i = 0; i < aName.length(); i++)
					{
						if(Character.isLetter(aName.charAt(i)) && Character.isUpperCase(aName.charAt(i)))
						{
							counter++;
						}
					}
					if(counter != aName.length())
					{
						return false;
					}
					return true;
	}
	
	
	//Set the abreviated name under circumstances.
	@Override
	public void setAbreviatedName(String aName)
	{
		//Check valid requirements
		if(verifyAbreviatedName(aName))
				abrName = aName;
	}
	
	
	//Get the abreviated name.
	@Override
	public String getAbreviatedName()
	{
		return abrName;
	}
	
	
	//Set price per share. 
	@Override
	public void setPurchasePricePerShare(int price)
	{
		if(price > 0)
		{
			pricePerShare = price;
		}
	}
	
	//Get price per share. 
	@Override
	public int getPurchasePricePerShare( )
	{
		return pricePerShare;
	}
	
	
	//Set number of shares. 
	@Override
	public void setNumberOfShares(int num)
	{
		if(num > 0) 
		{
		numOfShares = num;	
		}
	}
	
	//Get number of shares. 
	@Override
	public int getNumberOfShares()
	{
		return numOfShares;
	}
	
	@Override
	public String toString()
	{
		return ("Name: " + givenName);
	}
}
