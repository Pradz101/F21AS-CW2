import java.util.Random;


public class OrderGenerator {

	
	Random randF = new Random();
	Random randB = new Random();
	Random randS = new Random();
	Random random = new Random();

	
	String orderID;
	String itemID1, itemID2, itemID3, itemID4;
	int itemQ1, itemQ2, itemQ3, itemQ4;
	double totalTime;
	double totalCost;
	
	
	public Order generateOrder(int c) {
	
		String order;
		c++;
		
		orderID ="CO"+c;
		itemID1=getOrderF();
		itemID2=getOrderB();
		itemID3=getOrderS();
		itemID4=getOrderF();
		
		itemQ1=random.nextInt(4)+1;
		itemQ2=random.nextInt(2)+1;
		itemQ3=random.nextInt(2)+1;
		itemQ4=random.nextInt(3)+1;
		
		Random r = new Random();
		totalTime= 3000 + (5000 - 3000) *r.nextDouble();
		totalCost=35.5;
		
		Order o = new Order(orderID, itemID1, itemID2,itemID3, itemID4,
			itemQ1, itemQ2, itemQ3, itemQ4,
			totalTime,totalCost);
		
		
		return o;
	}
	
	
	public String getOrderF() { 
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
	public String getOrderB() { 
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
	
	public String getOrderS() { 
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
