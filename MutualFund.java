package finalPartII;
//Katie Olson: Final Project - this is the Mutual Fund Class
import java.io.Serializable;

public class MutualFund extends SecurityTypes implements Serializable
{
	double numOfShares;

	
	//Set number of shares.
	public void setNumberOfShares(double num)
	{
		if(num > 0) 
		{
		numOfShares = num;	
		}
	}
	
	//Get number of shares. 
	public double getNumberOfSharesFractional()
	{
		return numOfShares;
	}
	
	//Super tostring
		public String toString()
		{
			return ("Mutual Fund: " + super.toString());
		}
}
