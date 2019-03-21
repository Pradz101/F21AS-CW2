package model;
import java.util.Random;

/**
 * Order Generator Class
 * 
 * @author Shahra
 * @since   14-03-2019
 *
 */

public class OrderGenerator {
	
	/**
	 * random number generation for food, beverage and sweet id's
	 */
	Random randF 	= new Random();
	Random randB 	= new Random();
	Random randS	= new Random();
	Random random 	= new Random();
	
	/**
	 * 
	 * @param orderID
	 * @param itemID1
	 * @param itemID2
	 * @param itemID3
	 * @param itemID4
	 * @param itemQ1
	 * @param itemQ2
	 * @param itemQ3
	 * @param itemQ4
	 * @param totalTime
	 * @param totalCost
	 */

	
	String orderID;
	String itemID1, itemID2, itemID3, itemID4;
	int itemQ1, itemQ2, itemQ3, itemQ4;
	double totalTime;
	double totalCost;
	
	
	/**
	 * 
	 * @param order no
	 * @return order information
	 */
	
	public Order generateOrder(int c) {
	
		c++;
		
		orderID =	"CO"+c;
		itemID1	=	getOrderF();
		itemID2	=	getOrderB();
		itemID3	=	getOrderS();
		itemID4	=	getOrderF();
		
		/**
		 * assigning random integer to the item quantities
		 */
		
		itemQ1	=	random.nextInt(4)+1;
		itemQ2	=	random.nextInt(2)+1;
		itemQ3	=	random.nextInt(2)+1;
		itemQ4	=	random.nextInt(3)+1;
		
		/**
		 * generating total time and cost
		 */
		Random r = new Random();
		totalTime = 3000 + (5000 - 3000) * r.nextDouble();
		totalCost =	35.5 + (120 - 35.5)  * r.nextDouble();
		
		Order o = new Order(orderID, itemID1, itemID2,itemID3, itemID4,
			itemQ1, itemQ2, itemQ3, itemQ4,
			totalTime,totalCost);
		
		
		return o;
	}
	
	/**
	 * 
	 * @return food id
	 */
	
	public String getOrderF() { 
		
		/**
		 * switch case to assign food id
		 */
		int f = randF.nextInt(5)+1;
		switch(f) {
		case 1:
			return "FOOD001";
		case 2:
			return "FOOD002";
		case 3:
			return "FOOD003";
		case 4:
			return "FOOD004";
		default:
			return "null";
		}

	}
	
	/**
	 * 
	 * @return beverage id
	 */
	public String getOrderB() { 
		
		/**
		 * switch case to assign beverage id
		 */
		int b = randB.nextInt(5)+1;
		switch(b) {
		case 1:
			return "BEVE001";
		case 2:
			return "BEVE002";
		default:
			return "null";
		}

	}
	
	/**
	 * 
	 * @return sweet id
	 */
	
	public String getOrderS() { 
		
		/**
		 * switch case to assign sweet id
		 */
		int s = randS.nextInt(5)+1;
		switch(s) {
		case 1:
			return "SWEET01";
		case 2:
			return "SWEET02";
		case 3:
			return "SWEET03";
		case 4:
			return "SWEET04";
		default:
			return "null";
		}

	}
	
}
