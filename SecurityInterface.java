package finalPartII;
//Katie Olson: Final Project - interface for base class
public interface SecurityInterface 
{
	//These are common methods amongst all given classes.
	void setName(String specificName);
	String getName();
	void setAbreviatedName(String aName);
	String getAbreviatedName();
	void setPurchasePricePerShare(int price);
	int getPurchasePricePerShare();
	void setNumberOfShares(int num);
	int getNumberOfShares();
}
