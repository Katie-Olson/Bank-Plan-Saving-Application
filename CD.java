package finalPartII;
//Katie Olson: Final Project - this is the CD Class
import java.io.Serializable;

public class CD extends SecurityTypes implements Serializable
{
	int pricePerShare = 1;
	
	//Set price per share- Oh wait, it's one and shall only be one!
		@Override
		public void setPurchasePricePerShare(int price)
		{
			pricePerShare = 1; 
		}
		
		public int getPurchasePricePerShare()
		{
			return 1;
		}
	
		//Super tostring
		public String toString()
		{
			return ("CD: " + super.toString());
		}

}
