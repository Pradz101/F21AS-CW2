/**
* Getters and Setters for Order class
* 
* @author  Moiz
* @since   14-03-2019 
*/

package model;
import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import interfaces.Observer;
import interfaces.Subject;


/**
 * This class is used to add to get and set
 * order parameters
*/

public class Order implements Subject
{
	
	String orderID;
	String itemID1, itemID2, itemID3, itemID4;
	int itemQ1, itemQ2, itemQ3, itemQ4;
	double totalTime;
	double totalCost;
	
	/**Constructor
	 * 
	 * @param order_id
	 * @param item_id1
	 * @param item_id2
	 * @param item_id3
	 * @param item_id4
	 * @param item_quantity1
	 * @param item_quantity2
	 * @param item_quantity3
	 * @param item_quantity4
	 * @param totalTime
	 * @param totalCost
	 */

	public Order(String order_id, String item_id1, String item_id2, String item_id3, String item_id4,
			int item_quantity1, int item_quantity2, int item_quantity3, int item_quantity4,
			double totalTime,double totalCost) {

		orderID = order_id;
		
		itemID1 = item_id1;
		itemID2 = item_id2;
		itemID3 = item_id3;
		itemID4 = item_id4;
		
		itemQ1 = item_quantity1;
		itemQ2 = item_quantity2;
		itemQ3 = item_quantity3;
		itemQ4 = item_quantity4;
		
		this.totalTime = totalTime;
		
		this.totalCost = totalCost;
		

	}
	
	/**Gets total cost
	 * 
	 * @return totalcost
	 */

	public double getTotalCost() {
		return totalCost;
	}
	
	/**sets total cost
	 * 
	 * @param totalCost
	 */

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	/**returns order i
	 * 
	 * @return orderID
	 */

	public String getOrderID() {
		return orderID;
	}
	
	/**gets orderidno
	 * 
	 * @return n
	 */
	
	public int getOrderIDno() {
		int n;
		char N= orderID.charAt(2);
		n = Integer.parseInt(String.valueOf(N));
		
		return n;
	}
	
	/**sets order id
	 * 
	 * @param orderID
	 */

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	/**
	 * 
	 * @param itemNo
	 * @return null
	 */

	public String getItemID(int itemNo) {
		
		if(itemID1.equals("null"))
			setItemID1("       ");
		else if(itemID2.equals("null"))
			setItemID2("       ");
		else if(itemID3.equals("null"))
			setItemID3("       ");
		else if(itemID4.equals("null"))
			setItemID4("       ");
		
		switch(itemNo) {
		case 1:
			return itemID1;
		case 2:
			return itemID2;
		case 3:
			return itemID3;
		case 4:
			return itemID4;
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param itemID1
	 */

	public void setItemID1(String itemID1) {
		this.itemID1 = itemID1;
	}
	
	/**
	 * 
	 * @param itemID2
	 */


	public void setItemID2(String itemID2) {
		this.itemID2 = itemID2;
	}
	
	/**
	 * 
	 * @param itemID3
	 */

	public void setItemID3(String itemID3) {
		this.itemID3 = itemID3;
	}
	
	/**
	 * 
	 * @param itemID4
	 */

	public void setItemID4(String itemID4) {
		this.itemID4 = itemID4;
	}
	
	/**
	 * 
	 * @return itemQ1
	 */

	public int getItemQ1() {
		return itemQ1;
	}
	
	/**
	 * 
	 * @param itemQ1
	 */

	public void setItemQ1(int itemQ1) {
		this.itemQ1 = itemQ1;
	}
	
	/**
	 * 
	 * @return itemQ2
	 */

	public int getItemQ2() {
		return itemQ2;
	}
	
	/**
	 * 
	 * @param itemQ2
	 */

	public void setItemQ2(int itemQ2) {
		this.itemQ2 = itemQ2;
	}
	
	/**
	 * 
	 * @return itemQ3
	 */

	public int getItemQ3() {
		return itemQ3;
	}
	
	/**
	 * 
	 * @param itemQ3
	 */

	public void setItemQ3(int itemQ3) {
		this.itemQ3 = itemQ3;
	}
	
	/**
	 *  
	 * @return itemQ4
	 */

	public int getItemQ4() {
		return itemQ4;
	}
	
	/**
	 * 
	 * @param itemQ4
	 */

	public void setItemQ4(int itemQ4) {
		this.itemQ4 = itemQ4;
	}
	
	/**
	 * 
	 * @return totaltime divided by speed
	 */

	public double getTotalTime(double s) {
		return totalTime/s;
	}
	
	/**returns total time
	 * 
	 * @param totalTime
	 */

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}	
	
	/**returns order information
	 * 
	 * @return order information
	 */
	public String getOrderInformation() 
	{
		String orderInfo;	
		orderInfo = "Order No. " + getOrderID()+"\n\n"+ getItemID(1) + " x "+ getItemQ1() +"\n"+ getItemID(2) + " x "+ getItemQ2()  
		+ "\n"+ getItemID(3)+ " x "+ getItemQ3() + "\n"+ getItemID(4) + " x "+ getItemQ4() + "\n\n"
		 +"Total Cost: " + getTotalCost()+" AED\n--------------------------------------------\n\n";		
		return orderInfo;
	}
	
	/**
	 * this is the observer list
	 */
	private List<Observer> registeredObservers = new LinkedList<Observer>();


	/**
	 * adding the registered observer
	 */
	public void registerObserver(Observer obs) {
		registeredObservers.add(obs);
	}
	
	/**
	 *  removing the registered observer
	 */

	public void removeObserver(Observer obs) {
		registeredObservers.remove(obs);
	}
	
	/**
	 * notifying the observer
	 */
	public void notifyObservers() {
		for (Observer obs : registeredObservers)
			obs.update();
	}
	
}