package finalPartII;
//Katie Olson: Final Project - this is the Dividend Stock Class
public class DividendStock extends Stock
{
	double amountPerDividendShare = 0;
	
	
	//set dividend amount per share
	protected void setDividendAmountPerShare(double amount)
	{
		if(amount > 0)
		{
			amountPerDividendShare = amount;
		}
	}
	
	//get dividend amount per share
	protected double getDividendAmountPerShare()
	{
		return amountPerDividendShare;
	}
	
	//Super tostring
	public String toString()
	{
		return ("Dividend Stock: " + super.toString());
	}
}
